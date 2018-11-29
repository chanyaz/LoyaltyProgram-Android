package com.loyalty.customer.di

import com.loyalty.customer.usecases.qr.LoadQrString
import org.koin.dsl.module.module

val useCasesModule = module {
    single<LoadQrString> { LoadQrString(get()) }
}