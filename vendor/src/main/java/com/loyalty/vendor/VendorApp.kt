package com.loyalty.vendor

import com.loyalty.core.BaseApp
import com.loyalty.core.util.delegates.ApplicationDelegate
import org.koin.dsl.module.Module

class VendorApp : BaseApp() {

    override val clientModules: List<Module> get() = emptyList()

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {
        var application: VendorApp by ApplicationDelegate()
    }
}