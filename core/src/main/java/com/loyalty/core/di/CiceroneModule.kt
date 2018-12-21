package com.loyalty.core.di

import com.loyalty.core.BaseApp
import com.loyalty.core.presentation.navigation.router.Router
import com.loyalty.core.presentation.navigation.subnavigation.LocalCiceroneHolder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val ciceroneModule = module {
    single<LocalCiceroneHolder> { LocalCiceroneHolder() }
    single<Router> { (androidApplication() as BaseApp).router }
}