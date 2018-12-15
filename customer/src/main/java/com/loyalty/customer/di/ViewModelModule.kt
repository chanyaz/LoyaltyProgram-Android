package com.loyalty.customer.di

import com.loyalty.customer.presentation.coordinator.CoordinatorViewModel
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel1
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel2
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel3
import com.loyalty.customer.presentation.qr.QrViewModel
import com.loyalty.customer.presentation.qr.QrViewModelImpl
import com.loyalty.customer.presentation.venues.VenuesViewModel
import com.loyalty.customer.presentation.venues.VenuesViewModelImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { CoordinatorViewModel(get()) }
    viewModel<QrViewModel> { QrViewModelImpl(get()) }
    viewModel<VenuesViewModel> { VenuesViewModelImpl(get(), get()) }

    viewModel { TestViewModel1() }
    viewModel { TestViewModel2() }
    viewModel { TestViewModel3() }
}