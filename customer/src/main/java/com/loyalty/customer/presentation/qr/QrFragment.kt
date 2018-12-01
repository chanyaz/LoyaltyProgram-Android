package com.loyalty.customer.presentation.qr

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.qr_fragment.qrCodeView
import kotlinx.android.synthetic.main.qr_fragment.qrContent
import kotlinx.android.synthetic.main.qr_fragment.qrProgressBar
import org.koin.android.viewmodel.ext.android.viewModel

class QrFragment : MvvmFragment<QrState, BaseEvent>() {

    override val layout: Int get() = R.layout.qr_fragment

    override val viewModel: QrViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        qrCodeView.post {
            viewModel.initViewModel(qrWidth = qrCodeView.width, qrHeight = qrCodeView.height)
        }
    }

    override fun processState(state: QrState) {
        super.processState(state)
        when (state) {
            is QrState.QrLoading -> processLoadingState()
            is QrState.QrError -> processLoadingState()
            is QrState.QrLoaded -> processQrLoadedState(state)
        }.exhaustive
    }

    private fun processLoadingState() {
        qrContent.gone()
        qrProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processQrLoadedState(state: QrState.QrLoaded) {
        qrContent.visible()
        qrProgressBar.gone()
        qrCodeView.setImageBitmap(state.bitmap)
    }

}