package com.loyalty.vendor.presentation.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.vendor.usecases.scan.ProcessBarcode

class ScanViewModelImpl(
        private val processBarcode: ProcessBarcode
) : ScanViewModel() {

    init {
        setState(ScanState())
    }

    override fun initialiseCamera() {
        setState(currentState.copy(shouldInitialiseCamera = true))
    }

    override fun scanBarcode(barcodeResult: BarcodeResult) {
        if (currentState.isLoading || currentState.isBottomSheetShown)
            return

        setState(currentState.copy(shouldInitialiseCamera = false, isLoading = true, isError = false))
        subscribe(processBarcode(barcodeResult)
                .subscribe({
                    setState(currentState.copy(customer = it, shouldInitialiseCamera = false, isBottomSheetShown = true, isLoading = false, isError = false))
                }, {
                    setState(currentState.copy(shouldInitialiseCamera = false, isBottomSheetShown = false, isLoading = false, isError = true))
                })
        )
    }

}