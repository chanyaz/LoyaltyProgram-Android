package com.loyalty.customer

import com.loyalty.core.BaseApp
import com.loyalty.customer.di.viewModelModule
import org.koin.dsl.module.Module

class CustomerApp : BaseApp() {

    override val clientModules: List<Module> = listOf(viewModelModule)

}