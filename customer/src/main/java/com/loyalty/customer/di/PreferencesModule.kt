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
    factory<Encryptor> {
        EncryptorImpl(
                context = androidApplication(),
                computation = get(name = BaseConsts.SCHEDULER_COMPUTATION),
                alias = BuildConfig.APPLICATION_ID
        )
    }
    factory<TokenPreferences> {
        TokenPreferencesImpl(
                context = androidApplication(),
                encryptor = get(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    factory<QrPreferences> {
        QrPreferencesImpl(
                context = androidApplication(),
                encryptor = get(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    factory<VenuesVPreferences> {
        VenuesVPreferencesImpl(
                context = androidApplication(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
    factory<LocationPreferences> {
        FakeLocationPreferences(
                context = androidApplication(),
                io = get(name = BaseConsts.SCHEDULER_IO)
        )
    }
}