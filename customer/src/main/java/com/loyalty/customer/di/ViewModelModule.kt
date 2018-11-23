package com.loyalty.customer.di

import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel1
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel2
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel3
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { TestViewModel1(get()) }
    viewModel { TestViewModel2(get()) }
    viewModel { TestViewModel3(get()) }
}