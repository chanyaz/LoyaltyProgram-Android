package com.loyalty.customer.preferences.customer

import android.content.Context
import com.loyalty.core.storage.keystore.Encryptor
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class TokenPreferencesImpl(
        context: Context,
        private val encryptor: Encryptor,
        io: Scheduler
) : RxPreferences(context, Consts.TOKEN_PREFERENCES, io), TokenPreferences {

    override fun saveCustomerToken(token: String): Completable =
            encryptor.encryptString(token)
                    .flatMapCompletable { saveString(KEY_CUSTOMER_TOKEN, it) }

    override fun getCustomerToken(): Single<String> =
            getString(KEY_CUSTOMER_TOKEN)
                    .flatMap { encryptor.decryptString(it) }

    override fun isUserLoggedIn(): Single<Boolean> =
            getString(KEY_CUSTOMER_TOKEN)
                    .map { it.isNotEmpty() }

    companion object {
        private const val KEY_CUSTOMER_TOKEN = "KEY_CUSTOMER_TOKEN"
    }

}