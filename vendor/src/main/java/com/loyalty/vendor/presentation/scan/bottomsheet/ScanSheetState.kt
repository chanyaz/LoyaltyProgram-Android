package com.loyalty.vendor.presentation.scan.bottomsheet

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.vendor.ui.models.CustomerSheetUIModel

data class ScanSheetState(
        val customer: CustomerSheetUIModel? = null
) : BaseState()