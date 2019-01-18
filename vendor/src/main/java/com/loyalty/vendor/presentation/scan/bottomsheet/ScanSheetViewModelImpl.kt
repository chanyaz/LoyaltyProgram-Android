package com.loyalty.vendor.presentation.scan.bottomsheet

import com.loyalty.vendor.ui.models.CustomerSheetUIModel

class ScanSheetViewModelImpl : ScanSheetViewModel() {

    override val initialState: ScanSheetState get() = ScanSheetState()

    private var customer: CustomerSheetUIModel? = null

    override fun initViewModel(customer: CustomerSheetUIModel?) {
        if (this.customer == null)
            this.customer = customer

        setState(currentState.copy(customer = customer))
    }



}