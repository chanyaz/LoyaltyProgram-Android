package com.loyalty.vendor

import com.loyalty.core.BaseApp
import com.loyalty.core.util.delegates.ApplicationDelegate
import com.loyalty.vendor.di.viewModelModule
import org.koin.dsl.module.Module

class VendorApp : BaseApp() {

    override val clientModules: List<Module> get() = listOf(
            viewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {
        var application: VendorApp by ApplicationDelegate()
    }
}