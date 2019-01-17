package com.loyalty.vendor.presentation.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.core.util.SingleEventFlag
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import com.loyalty.vendor.usecases.scan.ProcessBarcode
import timber.log.Timber

class ScanViewModelImpl(
        private val processBarcode: ProcessBarcode
) : ScanViewModel() {

    override val initialState: ScanState get() = ScanState()

    override fun initialiseCamera() {
        launchCamera()
    }

    private fun launchCamera() {
        if (currentState.bottomSheetState.isBottomSheetPresent)
            return

        setState(currentState.copy(cameraState = CameraState(
                isCameraShown = true,
                isCameraRunning = true
        )))
    }

    override fun turnOffCamera() {
        setState(currentState.copy(cameraState = CameraState(
                isCameraShown = false,
                isCameraRunning = false
        )))
    }

    override fun resumeCamera() {
        launchCamera()
    }

    override fun pauseCamera() {
        setState(currentState.copy(cameraState = CameraState(
                isCameraShown = true,
                isCameraRunning = false
        )))
    }

    override fun scanBarcode(barcodeResult: BarcodeResult) {
        setState(currentState.copy(
                cameraState = CameraState(
                        isCameraShown = true,
                        isCameraRunning = false
                ),
                isLoading = true
        ))
        subscribe(processBarcode(barcodeResult)
                .observeOnUi()
                .subscribe(::onProcessBarcodeSuccess, ::onProcessBarcodeError)
        )
    }

    private fun onProcessBarcodeSuccess(customer: CustomerSheetUIModel) {
        setState(currentState.copy(
                customer = customer,
                cameraState = CameraState(
                        isCameraShown = true,
                        isCameraRunning = false
                ),
                bottomSheetState = BottomSheetState(
                        isBottomSheetPresent = true,
                        shouldShowBottomSheet = SingleEventFlag(true)
                ),
                isLoading = false
        ))
    }

    private fun onProcessBarcodeError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isError = true))
    }

    override fun closeBottomSheet() {
        setState(initialState.copy(
                cameraState = CameraState(
                        isCameraShown = true,
                        isCameraRunning = true
                )
        ))
    }

}