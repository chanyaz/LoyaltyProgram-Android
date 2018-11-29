package com.loyalty.customer.presentation.qr

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.processQr
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.qr_fragment.qrCodeView
import kotlinx.android.synthetic.main.qr_fragment.qrContent
import kotlinx.android.synthetic.main.qr_fragment.qrProgressBar
import org.koin.android.viewmodel.ext.android.viewModel

class QrFragment : MvvmFragment<QrState, BaseEvent>() {

    override val layout: Int get() = R.layout.qr_fragment

    override val viewModel: QrViewModel by viewModel()

    override fun processState(state: QrState) {
        super.processState(state)
        when(state) {
            is QrState.QrLoading -> processLoadingState()
            is QrState.QrError -> processLoadingState()
            is QrState.QrLoaded -> processLoadedState(state)
        }.exhaustive
    }

    private fun processLoadingState() {
        qrContent.invisible()
        qrProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(state: QrState.QrLoaded) {
        qrContent.visible()
        qrProgressBar.gone()
        qrCodeView.processQr(state.qrCodeString)
    }

}