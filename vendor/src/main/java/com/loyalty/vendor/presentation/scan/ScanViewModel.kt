package com.loyalty.vendor.presentation.scan

import com.journeyapps.barcodescanner.BarcodeResult
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class ScanViewModel : BaseViewModel<ScanState, BaseEvent>() {

    abstract fun initialiseCamera()

    abstract fun turnOffCamera()

    abstract fun resumeCamera()

    abstract fun pauseCamera()

    abstract fun scanBarcode(barcodeResult: BarcodeResult)

    abstract fun closeBottomSheet()

}