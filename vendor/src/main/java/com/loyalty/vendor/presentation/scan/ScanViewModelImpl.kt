package com.loyalty.vendor.presentation.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import com.loyalty.vendor.usecases.scan.ProcessBarcode
import timber.log.Timber

class ScanViewModelImpl(
        private val processBarcode: ProcessBarcode
) : ScanViewModel() {

    override val initialState: ScanState get() = ScanState()

    override fun initialiseCamera() {
        setState(initialState.copy(shouldInitialiseCamera = true))
    }

    override fun scanBarcode(barcodeResult: BarcodeResult) {
        if (currentState.isLoading || currentState.shouldShowBottomSheet)
            return

        setState(initialState.copy(isLoading = true))
        subscribe(processBarcode(barcodeResult)
                .observeOnUi()
                .subscribe(::onProcessBarcodeSuccess, ::onProcessBarcodeError)
        )
    }

    private fun onProcessBarcodeSuccess(customer: CustomerSheetUIModel) {
        setState(initialState.copy(customer = customer, shouldShowBottomSheet = true))
    }

    private fun onProcessBarcodeError(error: Throwable) {
        Timber.e(error)
        setState(initialState.copy(isError = true))
    }

    override fun closeBottomSheet() {
        setState(initialState)
    }

}