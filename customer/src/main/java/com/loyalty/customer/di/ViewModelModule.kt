package com.loyalty.customer.di

import com.loyalty.customer.presentation.navigation.NavigationViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<NavigationViewModel> { NavigationViewModel() }
}