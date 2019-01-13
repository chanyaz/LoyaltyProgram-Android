package com.loyalty.vendor.presentation.scan

import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DefaultDecoderFactory
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.vendor.Consts
import com.loyalty.vendor.R
import android.Manifest
import kotlinx.android.synthetic.main.scan_fragment.qrScanner
import org.koin.android.ext.android.inject

class ScanFragment : MvvmFragment<ScanState, BaseEvent>() {

    override val layout: Int get() = R.layout.scan_fragment

    override val viewModel: ScanViewModel by inject()

    private val callback = object : BarcodeCallback {
        override fun barcodeResult(result: BarcodeResult) = Unit
        override fun possibleResultPoints(resultPoints: List<ResultPoint>) = Unit
    }

    override fun onStart() {
        super.onStart()
        executeWithPermission(Manifest.permission.CAMERA, { viewModel.initialiseCamera() }, {})
    }

    override fun onResume() {
        super.onResume()
        qrScanner.resume()
    }

    override fun onPause() {
        super.onPause()
        qrScanner.pause()
    }

    override fun processState(state: ScanState) {
        super.processState(state)
        if (state.isCameraInitialised) {
            initCamera()
        }
    }

    private fun initCamera() {
        qrScanner.barcodeView.decoderFactory = DefaultDecoderFactory(Consts.QR_FORMATS)
        qrScanner.decodeContinuous(callback)
    }

    companion object {
        fun newInstance() : ScanFragment = ScanFragment()
    }

}