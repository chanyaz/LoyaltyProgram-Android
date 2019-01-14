package com.loyalty.vendor.di

import com.loyalty.vendor.usecases.scan.ProcessBarcode
import com.loyalty.vendor.usecases.scan.ProcessBarcodeImpl
import org.koin.dsl.module.module

val useCasesModule = module {

    /* Scan */

    factory<ProcessBarcode> { ProcessBarcodeImpl() }

}