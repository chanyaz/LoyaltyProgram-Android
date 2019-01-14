package com.loyalty.vendor.presentation.scan

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.vendor.ui.models.CustomerSheetUIModel

data class ScanState(
        val customer: CustomerSheetUIModel? = null,
        val shouldInitialiseCamera: Boolean = false,
        val isBottomSheetShown: Boolean = false,
        val isLoading: Boolean = false,
        val isError: Boolean = false
) : BaseState()