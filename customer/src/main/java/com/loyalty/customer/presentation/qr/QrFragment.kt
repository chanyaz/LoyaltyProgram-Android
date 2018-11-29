package com.loyalty.customer.presentation.qr

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.customer.R
import org.koin.android.viewmodel.ext.android.viewModel

class QrFragment : MvvmFragment<QrState, BaseEvent>() {

    override val layout: Int get() = R.layout.qr_fragment

    override val viewModel: BaseViewModel<QrState, BaseEvent> by viewModel()

    override fun processState(state: QrState) {
        super.processState(state)
        when(state) {
            is QrState.QrLoading -> processLoadingState()
            is QrState.QrLoaded -> processLoadedState(state)
        }.exhaustive
    }

    private fun processLoadingState() {

    }

    private fun processLoadedState(state: QrState.QrLoaded) {

    }

}