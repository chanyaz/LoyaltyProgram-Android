package com.loyalty.customer.presentation.qr

import android.graphics.Bitmap
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.qr.LoadQrBitmapCase
import timber.log.Timber

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
                .subscribe(::onLoadQrCodeSuccess, ::onLoadQrCodeError))
    }

    private fun onLoadQrCodeSuccess(qrImage: Bitmap) {
        setState(QrState(isLoading = false, isError = false, qrBitmap = qrImage))
    }

    private fun onLoadQrCodeError(error: Throwable) {
        Timber.e(error)
        setState(QrState(isLoading = false, isError = true))
    }

}