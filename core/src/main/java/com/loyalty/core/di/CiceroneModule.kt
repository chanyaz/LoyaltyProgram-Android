package com.loyalty.core.di

import com.loyalty.core.presentation.navigation.subnavigation.LocalCiceroneHolder
import org.koin.dsl.module.module

val ciceroneModule = module {
    single<LocalCiceroneHolder> { LocalCiceroneHolder() }
}