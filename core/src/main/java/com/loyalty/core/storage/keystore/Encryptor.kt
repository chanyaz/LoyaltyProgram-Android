package com.loyalty.core.storage.keystore

import io.reactivex.Completable
import io.reactivex.Single

interface Encryptor {
    fun createNewKeys(): Completable
    fun deleteKeys(): Completable
    fun encryptString(text: String): Single<String>
    fun decryptString(encryptedText: String): Single<String>
}