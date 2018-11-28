package com.loyalty.customer.preferences

import android.content.Context
import com.loyalty.core.storage.keystore.Encryptor
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class CustomerPreferencesImpl(
        context: Context,
        private val encryptor: Encryptor,
        io: Scheduler
) : RxPreferences(context, Consts.CUSTOMER_PREFERENCES, io), CustomerPreferences {

    override fun saveCustomerToken(token: String): Completable =
            encryptor.encryptString(token)
                    .flatMapCompletable { saveString(CUSTOMER_TOKEN, it) }

    override fun getCustomerToken(): Single<String> =
            getString(CUSTOMER_TOKEN)
                    .flatMap { encryptor.decryptString(it) }

    override fun isUserLoggedIn(): Single<Boolean> =
            getString(CUSTOMER_TOKEN)
                    .map { it.isNotEmpty() }

    companion object {
        private const val CUSTOMER_TOKEN = "CUSTOMER_TOKEN"
    }

}