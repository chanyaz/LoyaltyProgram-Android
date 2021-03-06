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
import android.os.Bundle
import android.view.View
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.view.OnBottomSheetDismissListener
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.vendor.presentation.scan.bottomsheet.ScanSheetFragment
import com.loyalty.vendor.ui.models.CustomerSheetUIModel
import kotlinx.android.synthetic.main.scan_fragment.qrScanner
import kotlinx.android.synthetic.main.scan_fragment.scanFrameImage
import kotlinx.android.synthetic.main.scan_fragment.scanPointCameraText
import kotlinx.android.synthetic.main.scan_fragment.scanProgressBar
import org.koin.android.ext.android.inject

class ScanFragment : MvvmFragment<ScanState, BaseEvent>(), OnBottomSheetDismissListener {

    override val layout: Int get() = R.layout.scan_fragment

    override val viewModel: ScanViewModel by inject()

    private var bottomSheetFragment: ScanSheetFragment? = null

    private val callback = object : BarcodeCallback {
        override fun barcodeResult(result: BarcodeResult) {
            viewModel.scanBarcode(result)
        }
        override fun possibleResultPoints(resultPoints: List<ResultPoint>) = Unit
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        executeWithPermission(Manifest.permission.CAMERA, { viewModel.initialiseCamera() }, { viewModel.turnOffCamera() })

        childFragmentManager.fragments.forEach { /* todo remove this when the fragments state is saved the appropriate way! */
            childFragmentManager.beginTransaction().remove(it).commit()
        }
    }

    override fun onStart() {
        super.onStart()
        executeWithPermission(Manifest.permission.CAMERA, { viewModel.initialiseCamera() }, { viewModel.turnOffCamera() })
    }

    override fun onResume() {
        super.onResume()
        executeIfPermissionGranted(Manifest.permission.CAMERA, { viewModel.resumeCamera() }, { viewModel.turnOffCamera() })
    }

    override fun onPause() {
        super.onPause()
        executeIfPermissionGranted(Manifest.permission.CAMERA, { viewModel.pauseCamera() }, { viewModel.turnOffCamera() })
    }

    override fun renderState(state: ScanState) {
        super.renderState(state)

        val cameraState = state.cameraState
        val sheetState = state.bottomSheetState

        if (!cameraState.isCameraShown) {
            renderCameraNotShown()
        } else if (cameraState.isCameraShown && cameraState.isCameraRunning && !sheetState.isBottomSheetPresent) {
            renderCameraRunning()
        } else if (cameraState.isCameraShown && !cameraState.isCameraRunning) {
            renderCameraPaused()
        } else {
            throw UnexpectedStateException(state.toString())
        }

        val shouldShowBottomSheet = sheetState.shouldShowBottomSheet.value
        if (shouldShowBottomSheet && !state.isLoading && !state.isError && state.customer != null) {
            renderLoadedState(state.customer)
        }

        if (state.isLoading) {
            renderLoadingState()
        } else if (state.isError) {
            renderErrorState()
        } else if (!state.isLoading && !state.isError) {
            renderEmptyState()
        }
    }

    private fun renderCameraNotShown() {
        scanFrameImage.invisible()
        scanPointCameraText.invisible()
    }

    private fun renderCameraRunning() {
        qrScanner.apply {
            barcodeView.decoderFactory = DefaultDecoderFactory(Consts.QR_FORMATS)
            decodeSingle(callback)
            resume()
        }
        scanFrameImage.visible()
        scanPointCameraText.visible()
    }

    private fun renderCameraPaused() {
        scanFrameImage.visible()
        scanPointCameraText.visible()
        qrScanner.pause()
    }

    private fun renderLoadingState() {
        scanProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderEmptyState() {
        scanProgressBar.gone()
    }

    private fun renderLoadedState(customer: CustomerSheetUIModel) {
        scanProgressBar.gone()
        bottomSheetFragment?.dismiss()
        bottomSheetFragment = ScanSheetFragment.newInstance(customer)
        bottomSheetFragment?.show(childFragmentManager, "")
    }

    override fun onBottomSheetDismiss() {
        viewModel.closeBottomSheet()
    }

    companion object {
        fun newInstance() : ScanFragment = ScanFragment()
    }

}