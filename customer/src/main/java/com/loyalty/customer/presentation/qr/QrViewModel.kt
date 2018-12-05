package com.loyalty.customer.presentation.qr

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.qr.LoadQrBitmapCase

class QrViewModel(
        private val loadQrBitmapCase: LoadQrBitmapCase
) : BaseViewModel<QrState, BaseEvent>() {

    fun initViewModel(qrWidth: Int, qrHeight: Int) {
        setState(QrState.QrLoading)
        loadQrCode(qrWidth, qrHeight)
    }

    private fun loadQrCode(qrWidth: Int, qrHeight: Int) {
        subscribe(loadQrBitmapCase.loadQrBitmap(width = qrWidth, height = qrHeight)
                .observeOnUi()
                .subscribe({
                    setState(QrState.QrLoaded(it))
                }, {
                    setState(QrState.QrError)
                }))
    }

}