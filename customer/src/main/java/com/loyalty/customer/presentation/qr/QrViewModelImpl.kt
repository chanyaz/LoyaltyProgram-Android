package com.loyalty.customer.presentation.qr

import android.graphics.Bitmap
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.qr.LoadQrStringCase
import com.loyalty.customer.usecases.qr.StringToQrBitmapCase
import timber.log.Timber

class QrViewModelImpl(
        private val loadQrStringCase: LoadQrStringCase,
        private val stringToQrBitmapCase: StringToQrBitmapCase
) : QrViewModel() {

    override val initialState: QrState get() = QrState()

    init {
        loadData()
    }

    private fun loadData() {
        subscribe(loadQrStringCase()
                .observeOnUi()
                .subscribe({}, ::onLoadQrCodeError))
    }

    private fun onLoadQrCodeError(error: Throwable) {
        Timber.e(error)
        setState(QrState(isLoading = false, isError = true))
    }

    override fun drawQrCode(qrWidth: Int, qrHeight: Int) {
        subscribe(loadQrStringCase()
                .flatMap { stringToQrBitmapCase(it, qrWidth, qrHeight) }
                .observeOnUi()
                .subscribe(::onDrawQrCodeSuccess, ::onDrawQrCodeError))
    }

    private fun onDrawQrCodeSuccess(qrCodeImage: Bitmap) {
        setState(QrState(isLoading = false, isError = false, qrBitmap = qrCodeImage))
    }

    private fun onDrawQrCodeError(error: Throwable) {
        Timber.e(error)
        setState(QrState(isLoading = false, isError = true))
    }

}