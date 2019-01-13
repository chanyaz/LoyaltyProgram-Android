package com.loyalty.vendor.presentation.scan

class ScanViewModelImpl : ScanViewModel() {

    init {
        setState(ScanState())
    }

    override fun initialiseCamera() {
        if (!currentState.isCameraInitialised) {
            setState(currentState.copy(isCameraInitialised = true))
        }
    }

}