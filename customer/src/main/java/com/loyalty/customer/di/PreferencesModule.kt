package com.loyalty.customer.di

import com.loyalty.core.BaseConsts
import com.loyalty.core.storage.keystore.Encryptor
import com.loyalty.core.storage.keystore.EncryptorImpl
import com.loyalty.customer.BuildConfig
import com.loyalty.customer.preferences.CustomerPreferences
import com.loyalty.customer.preferences.CustomerPreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val preferencesModule = module {
    single<Encryptor> {
        EncryptorImpl(
                context = androidApplication(),
                computation = get(name = BaseConsts.SCHEDULER_COMPUTATION),
                alias = BuildConfig.APPLICATION_ID
        )
    }
    single<CustomerPreferences> {
        CustomerPreferencesImpl(
                context = androidApplication(),
                encryptor = get(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
}