package com.loyalty.vendor.di

import com.loyalty.vendor.presentation.coordinator.CoordinatorViewModel
import com.loyalty.vendor.presentation.coordinator.CoordinatorViewModelImpl
import com.loyalty.vendor.presentation.scan.ScanViewModel
import com.loyalty.vendor.presentation.scan.ScanViewModelImpl
import com.loyalty.vendor.presentation.scan.bottomsheet.ScanBottomSheetViewModel
import com.loyalty.vendor.presentation.scan.bottomsheet.ScanBottomSheetViewModelImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<CoordinatorViewModel> { CoordinatorViewModelImpl() }
    viewModel<ScanViewModel> { ScanViewModelImpl(get()) }
    viewModel<ScanBottomSheetViewModel> { ScanBottomSheetViewModelImpl() }
}