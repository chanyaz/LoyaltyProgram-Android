package com.loyalty.core.storage.keystore

import android.content.Context
import android.security.KeyPairGeneratorSpec
import com.loyalty.core.exceptions.KeyAlreadyExistsException
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.interfaces.RSAPublicKey
import java.util.*
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.security.auth.x500.X500Principal

/**
 * Scheduler:
 * all the encryption operations should be made on the computation Scheduler
 */
class EncryptorImpl(private val context: Context, private val computation: Scheduler): Encryptor {

    private val keyStore: KeyStore = KeyStore.getInstance("AndroidKeyStore").apply {
        load(null)
    }

    override fun createNewKeys(): Completable {
        return Completable.fromCallable {
            if (keyStore.containsAlias(alias))
                throw KeyAlreadyExistsException()

            val start = Calendar.getInstance()
            val end = Calendar.getInstance().apply {
                add(Calendar.YEAR, 1)
            }

            val spec = KeyPairGeneratorSpec.Builder(context)
                    .setAlias(alias)
                    .setSubject(X500Principal("CN=Loyalty App, O=Android Authority"))
                    .setSerialNumber(BigInteger.ONE)
                    .setStartDate(start.time)
                    .setEndDate(end.time)
                    .build()
            val generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore")
            generator.initialize(spec)
            generator.generateKeyPair()
        }.subscribeOn(computation)
    }

    override fun deleteKeys(): Completable {
        return Completable.fromCallable {
            keyStore.deleteEntry(alias)
        }.subscribeOn(computation)
    }

    override fun encryptString(text: String): Single<String> {
        return createNewKeys()
                .onErrorComplete()
                .toSingle {
                    val privateKeyEntry = keyStore.getEntry(alias, null) as KeyStore.PrivateKeyEntry
                    val publicKey = privateKeyEntry.certificate.publicKey as RSAPublicKey

                    if (text.isEmpty())
                        return@toSingle ""

                    val input = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL")
                    input.init(Cipher.ENCRYPT_MODE, publicKey)

                    val outputStream = ByteArrayOutputStream()
                    val cipherOutputStream = CipherOutputStream(outputStream, input)
                    cipherOutputStream.write(text.toByteArray(charset("UTF-8")))
                    cipherOutputStream.close()

                    val vals = outputStream.toByteArray()
                    android.util.Base64.encodeToString(vals, android.util.Base64.DEFAULT)
                }.subscribeOn(computation)
    }

    override fun decryptString(encryptedText: String): Single<String> {
        return createNewKeys()
                .onErrorComplete()
                .toSingle {
                    val privateKeyEntry = keyStore.getEntry(alias, null) as KeyStore.PrivateKeyEntry

                    val output = Cipher.getInstance("RSA/ECB/PKCS1Padding")
                    output.init(Cipher.DECRYPT_MODE, privateKeyEntry.privateKey)

                    val cipherInputStream = CipherInputStream(
                            ByteArrayInputStream(android.util.Base64.decode(encryptedText, android.util.Base64.DEFAULT)), output)
                    val values = mutableListOf<Byte>()

                    var nextByte: Int = cipherInputStream.read()
                    while (nextByte != -1) {
                        values.add(nextByte.toByte())
                        nextByte = cipherInputStream.read()
                    }

                    val bytes = ByteArray(values.size)
                    for (i in bytes.indices) {
                        bytes[i] = values[i]
                    }

                    String(bytes, 0, bytes.size, charset("UTF-8"))
                }.subscribeOn(computation)
    }

    companion object {
        private const val alias = "loyalty_alias"
    }
}