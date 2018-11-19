package com.loyalty.customer

import com.loyalty.core.BaseApp
import com.loyalty.customer.di.viewModelModule
import org.koin.android.ext.android.startKoin

class CustomerApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(viewModelModule)
        startKoin(this, modules)
    }
}