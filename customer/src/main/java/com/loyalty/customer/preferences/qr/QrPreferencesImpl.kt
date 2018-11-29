package com.loyalty.customer.preferences.qr

import android.content.Context
import com.loyalty.core.storage.keystore.Encryptor
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class QrPreferencesImpl(
        context: Context,
        private val encryptor: Encryptor,
        io: Scheduler
) : RxPreferences(context, Consts.QR_PREFERENCES, io), QrPreferences {

    override fun saveQrCode(qrString: String): Completable =
            encryptor.encryptString(qrString)
                    .flatMapCompletable { saveString(KEY_QR_CODE, it) }

    override fun getQrCode(): Single<String> =
            getString(KEY_QR_CODE)
                    .flatMap { encryptor.decryptString(it) }

    companion object {
        private const val KEY_QR_CODE = "KEY_QR_CODE"
    }

}