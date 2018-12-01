package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import io.reactivex.Single

class LoadQrBitmapCaseImpl(
        private val loadQrStringCase: LoadQrStringCase,
        private val stringToQrBitmapCase: StringToQrBitmapCase
) : LoadQrBitmapCase {

    override fun loadQrBitmap(width: Int, height: Int): Single<Bitmap> =
            loadQrStringCase.loadQrString()
                    .flatMap {
                        stringToQrBitmapCase.stringToBitmap(it, width = width, height = height)
                    }

}