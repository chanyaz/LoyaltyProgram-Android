package com.loyalty.customer.di

import com.loyalty.core.BaseConsts
import com.loyalty.core.storage.keystore.Encryptor
import com.loyalty.core.storage.keystore.EncryptorImpl
import com.loyalty.customer.BuildConfig
import com.loyalty.customer.preferences.location.FakeLocationPreferences
import com.loyalty.customer.preferences.token.TokenPreferences
import com.loyalty.customer.preferences.token.TokenPreferencesImpl
import com.loyalty.customer.preferences.location.LocationPreferences
import com.loyalty.customer.preferences.qr.QrPreferences
import com.loyalty.customer.preferences.qr.QrPreferencesImpl
import com.loyalty.customer.preferences.venuesversion.VenuesVPreferences
import com.loyalty.customer.preferences.venuesversion.VenuesVPreferencesImpl
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
    single<TokenPreferences> {
        TokenPreferencesImpl(
                context = androidApplication(),
                encryptor = get(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    single<QrPreferences> {
        QrPreferencesImpl(
                context = androidApplication(),
                encryptor = get(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    single<VenuesVPreferences> {
        VenuesVPreferencesImpl(
                context = androidApplication(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    single<LocationPreferences> {
        FakeLocationPreferences(
                context = androidApplication(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
}