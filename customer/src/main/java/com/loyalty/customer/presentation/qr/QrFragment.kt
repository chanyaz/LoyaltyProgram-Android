package com.loyalty.customer.presentation.qr

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.qr_fragment.qrCodeImage
import kotlinx.android.synthetic.main.qr_fragment.qrProgressBar
import kotlinx.android.synthetic.main.qr_fragment.qrShowCashierHeader
import kotlinx.android.synthetic.main.qr_fragment.qrYourQrHeader
import org.koin.android.viewmodel.ext.android.viewModel

class QrFragment : MvvmFragment<QrState, BaseEvent>() {

    override val layout: Int get() = R.layout.qr_fragment

    override val viewModel: QrViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        qrCodeImage.post {
            viewModel.drawQrCode(qrWidth = qrCodeImage.width, qrHeight = qrCodeImage.height)
        }
    }

    override fun renderState(state: QrState) {
        super.renderState(state)
//        TransitionManager.beginDelayedTransition(qrFragment) todo consider moving this to common logic
        if (state.isLoading) {
            renderLoadingState()
        } else if (state.isError) {
            renderErrorState()
        } else if (!state.isLoading && !state.isError && state.qrBitmap != null) {
            renderLoadedState(state.qrBitmap)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun renderLoadingState() {
        qrShowCashierHeader.invisible()
        qrCodeImage.invisible()
        qrYourQrHeader.invisible()
        qrProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderLoadedState(qrImage: Bitmap) {
        qrShowCashierHeader.visible()
        qrCodeImage.visible()
        qrYourQrHeader.visible()
        qrProgressBar.gone()
        qrCodeImage.setImageBitmap(qrImage)
    }

    companion object {
        fun newInstance(): QrFragment = QrFragment()
    }

}