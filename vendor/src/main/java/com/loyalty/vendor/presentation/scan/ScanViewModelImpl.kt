package com.loyalty.vendor.presentation.scan

class ScanViewModelImpl : ScanViewModel() {

    init {
        setState(ScanState())
    }

    override fun initialiseCamera() {
        setState(currentState.copy(shouldInitialiseCamera = true))
    }

}