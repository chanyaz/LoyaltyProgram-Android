package com.loyalty.customer.di

import com.loyalty.customer.Consts
import com.loyalty.customer.network.interceptors.TokenInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import timber.log.Timber

val networkModule = module {
    single<Interceptor>(name = Consts.LOGGING_INTERCEPTOR) { buildLoggingInterceptor() }
    single<Interceptor>(name = Consts.TOKEN_INTERCEPTOR) { TokenInterceptor(get()) }
}

private fun buildLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Timber.d(message)
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }