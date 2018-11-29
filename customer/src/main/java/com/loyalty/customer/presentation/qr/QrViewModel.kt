package com.loyalty.customer.presentation.qr

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.qr.LoadQrString

class QrViewModel(
        private val loadQrString: LoadQrString
) : BaseViewModel<QrState, BaseEvent>() {

    init {
        setState(QrState.QrLoading)
        loadQrCode()
    }

    private fun loadQrCode() {
        subscribe(loadQrString.execute()
                .observeOnUi()
                .subscribe({
                    setState(QrState.QrLoaded(it))
                }, {
                    setState(QrState.QrError)
                }))
    }

}