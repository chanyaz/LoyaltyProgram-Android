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
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.visible
import com.loyalty.vendor.presentation.scan.bottomsheet.ScanBottomSheetFragment
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import kotlinx.android.synthetic.main.scan_fragment.qrScanner
import kotlinx.android.synthetic.main.scan_fragment.scanFrameImage
import kotlinx.android.synthetic.main.scan_fragment.scanPointCameraText
import kotlinx.android.synthetic.main.scan_fragment.scanProgressBar
import org.koin.android.ext.android.inject

class ScanFragment : MvvmFragment<ScanState, BaseEvent>() {

    override val layout: Int get() = R.layout.scan_fragment

    override val viewModel: ScanViewModel by inject()

    private var bottomSheetFragment: ScanBottomSheetFragment? = null

    private val callback = object : BarcodeCallback {
        override fun barcodeResult(result: BarcodeResult) {
            viewModel.scanBarcode(result)
        }
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

    override fun renderState(state: ScanState) {
        super.renderState(state)
        if (state.shouldInitialiseCamera) {
            initCamera()
        }

        if (state.isLoading) {
            renderLoadingState()
        } else if (state.isError) {
            renderErrorState()
        } else if (!state.isLoading && !state.isError && state.customer == null) {
            renderEmptyState()
        } else if (!state.isLoading && !state.isError && state.isBottomSheetShown && state.customer != null) {
            renderLoadedState(state.customer)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun initCamera() {
        qrScanner.barcodeView.decoderFactory = DefaultDecoderFactory(Consts.QR_FORMATS)
        qrScanner.decodeContinuous(callback)
        scanFrameImage.visible()
        scanPointCameraText.visible()
    }

    private fun renderLoadingState() {
        bottomSheetFragment?.dismiss()
        scanProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderEmptyState() {
        scanProgressBar.gone()
    }

    private fun renderLoadedState(customer: CustomerSheetUIModel) {
        bottomSheetFragment?.dismiss()
        scanProgressBar.gone()
        bottomSheetFragment = ScanBottomSheetFragment.newInstance(customer)
        bottomSheetFragment?.show(childFragmentManager, "")
    }

    companion object {
        fun newInstance() : ScanFragment = ScanFragment()
    }

}