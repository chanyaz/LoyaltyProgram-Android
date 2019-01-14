package com.loyalty.customer.presentation.qr

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.qr.LoadQrBitmapCase

class QrViewModelImpl(
        private val loadQrBitmapCase: LoadQrBitmapCase
) : QrViewModel() {

    override val initialState: QrState get() = QrState()

    override fun initViewModel(qrWidth: Int, qrHeight: Int) {
        setState(QrState())
        loadQrCode(qrWidth, qrHeight)
    }

    private fun loadQrCode(qrWidth: Int, qrHeight: Int) {
        subscribe(loadQrBitmapCase(width = qrWidth, height = qrHeight)
                .observeOnUi()
                .subscribe({
                    setState(QrState(isLoading = false, isError = false, qrBitmap = it))
                }, {
                    setState(QrState(isLoading = false, isError = true))
                }))
    }

}