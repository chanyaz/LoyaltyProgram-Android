package com.loyalty.customer.di

import com.loyalty.core.BaseConsts
import com.loyalty.customer.usecases.qr.LoadQrBitmapCase
import com.loyalty.customer.usecases.qr.LoadQrBitmapCaseImpl
import com.loyalty.customer.usecases.qr.LoadQrStringCase
import com.loyalty.customer.usecases.qr.LoadQrStringCaseImpl
import com.loyalty.customer.usecases.qr.StringToQrBitmapCase
import com.loyalty.customer.usecases.qr.StringToQrBitmapCaseImpl
import org.koin.dsl.module.module

val useCasesModule = module {
    single<LoadQrStringCase> { LoadQrStringCaseImpl(get()) }
    single<StringToQrBitmapCase> { StringToQrBitmapCaseImpl(get(name = BaseConsts.SCHEDULER_COMPUTATION)) }
    single<LoadQrBitmapCase> { LoadQrBitmapCaseImpl(get(), get()) }
}