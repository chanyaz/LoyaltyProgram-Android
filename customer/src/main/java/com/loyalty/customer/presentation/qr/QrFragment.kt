package com.loyalty.customer.presentation.qr

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.core.util.extensions.gone
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
            viewModel.initViewModel(qrWidth = qrCodeImage.width, qrHeight = qrCodeImage.height)
        }
    }

    override fun processState(state: QrState) {
        super.processState(state)
        when (state) {
            is QrState.QrLoading -> processLoadingState()
            is QrState.QrError -> processLoadingState()
            is QrState.QrLoaded -> processLoadedState(state)
        }.exhaustive
    }

    private fun processLoadingState() {
        qrShowCashierHeader.gone()
        qrCodeImage.gone()
        qrYourQrHeader.gone()
        qrProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(state: QrState.QrLoaded) {
        qrShowCashierHeader.visible()
        qrCodeImage.visible()
        qrYourQrHeader.visible()
        qrProgressBar.gone()
        qrCodeImage.setImageBitmap(state.bitmap)
    }

}