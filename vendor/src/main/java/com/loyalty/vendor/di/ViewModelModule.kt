package com.loyalty.vendor.di

val viewModelModule = module {
    viewModel { CoordinatorViewModel(get()) }
}