package com.loyalty.vendor.presentation.scan.bottomsheet

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.vendor.ui.models.CustomerSheetUIModel

abstract class ScanBottomSheetViewModel : BaseViewModel<ScanBottomSheetState, BaseEvent>() {

    abstract fun initViewModel(customer: CustomerSheetUIModel?)

}