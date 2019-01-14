package com.loyalty.vendor.presentation.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import com.loyalty.vendor.usecases.scan.ProcessBarcode

class ScanViewModelImpl(
        private val processBarcode: ProcessBarcode
) : ScanViewModel() {

    override val initialState: ScanState get() = ScanState()

    override fun initialiseCamera() {
        setState(currentState.copy(shouldInitialiseCamera = true))
    }

    override fun scanBarcode(barcodeResult: BarcodeResult) {
        if (currentState.isLoading || currentState.isBottomSheetShown)
            return

        setState(currentState.copy(shouldInitialiseCamera = false, isLoading = true, isError = false))
        subscribe(processBarcode(barcodeResult)
                .subscribe(::onProcessBarcodeSuccess, ::onProcessBarcodeError)
        )
    }

    private fun onProcessBarcodeSuccess(customer: CustomerSheetUIModel) {
        setState(currentState.copy(customer = customer, shouldInitialiseCamera = false, isBottomSheetShown = true, isLoading = false, isError = false))
    }

    private fun onProcessBarcodeError(error: Throwable) {
        setState(currentState.copy(shouldInitialiseCamera = false, isBottomSheetShown = false, isLoading = false, isError = true))
    }

}