package com.loyalty.vendor.presentation.scan.bottomsheet

import com.loyalty.vendor.ui.models.CustomerSheetUIModel

class ScanBottomSheetViewModelImpl : ScanBottomSheetViewModel() {

    private var customer: CustomerSheetUIModel? = null

    init {
        setState(ScanBottomSheetState())
    }

    override fun initViewModel(customer: CustomerSheetUIModel?) {
        if (this.customer == null)
            this.customer = customer

        setState(currentState.copy(customer = customer))
    }

}