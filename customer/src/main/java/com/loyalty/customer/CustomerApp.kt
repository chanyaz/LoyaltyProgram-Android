package com.loyalty.customer

import com.loyalty.core.BaseApp
import com.loyalty.core.util.delegates.ApplicationDelegate
import com.loyalty.customer.di.networkModule
import com.loyalty.customer.di.preferencesModule
import com.loyalty.customer.di.repositoryModule
import com.loyalty.customer.di.useCasesModule
import com.loyalty.customer.di.viewModelModule
import org.koin.dsl.module.Module

class CustomerApp : BaseApp() {

    override val clientModules: List<Module> = listOf(
            viewModelModule,
            preferencesModule,
            networkModule,
            repositoryModule,
            useCasesModule
    )

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {
        var application: CustomerApp by ApplicationDelegate()
    }

}