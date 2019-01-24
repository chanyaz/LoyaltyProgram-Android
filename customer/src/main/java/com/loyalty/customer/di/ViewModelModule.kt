package com.loyalty.customer.di

import com.loyalty.customer.presentation.cards.CardsViewModel
import com.loyalty.customer.presentation.cards.CardsViewModelImpl
import com.loyalty.customer.presentation.coordinator.CustomerFlowViewModel
import com.loyalty.customer.presentation.map.MapViewModel
import com.loyalty.customer.presentation.map.MapViewModelImpl
import com.loyalty.customer.presentation.map.bottomsheet.VenueSheetViewModel
import com.loyalty.customer.presentation.map.bottomsheet.VenueSheetViewModelImpl
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel1
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel2
import com.loyalty.customer.presentation.navigation.flows.test.TestViewModel3
import com.loyalty.customer.presentation.qr.QrViewModel
import com.loyalty.customer.presentation.qr.QrViewModelImpl
import com.loyalty.customer.presentation.venue.VenuePageViewModelImpl
import com.loyalty.customer.presentation.venue.VenuePageViewModel
import com.loyalty.customer.presentation.venues.VenuesViewModel
import com.loyalty.customer.presentation.venues.VenuesViewModelImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel {
        CustomerFlowViewModel(get())
    }
    viewModel<QrViewModel> {
        QrViewModelImpl(get(), get())
    }
    viewModel<VenuesViewModel> {
        VenuesViewModelImpl(get())
    }
    viewModel<VenuePageViewModel> {
        VenuePageViewModelImpl(get())
    }
    viewModel<CardsViewModel> {
        CardsViewModelImpl(get())
    }
    viewModel<MapViewModel> {
        MapViewModelImpl(get())
    }
    viewModel<VenueSheetViewModel> {
        VenueSheetViewModelImpl()
    }

    viewModel { TestViewModel1() }
    viewModel { TestViewModel2() }
    viewModel { TestViewModel3() }
}