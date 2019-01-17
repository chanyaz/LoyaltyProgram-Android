package com.loyalty.vendor.presentation.scan

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.util.SingleEventFlag
import com.loyalty.vendor.ui.models.CustomerSheetUIModel

data class ScanState(
        val customer: CustomerSheetUIModel? = null,
        val cameraState: CameraState = CameraState(),
        val bottomSheetState: BottomSheetState = BottomSheetState(),
        val isLoading: Boolean = false,
        val isError: Boolean = false
) : BaseState()

data class CameraState(
        val isCameraShown: Boolean = false,
        val isCameraRunning: Boolean = false
) : BaseState()

data class BottomSheetState(
        val isBottomSheetPresent: Boolean = false,
        val shouldShowBottomSheet: SingleEventFlag = SingleEventFlag(false)
)