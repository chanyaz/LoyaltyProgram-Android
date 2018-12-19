package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import io.reactivex.Single

class LoadQrBitmapCaseImpl(
        private val loadQrStringCase: LoadQrStringCase,
        private val stringToQrBitmapCase: StringToQrBitmapCase
) : LoadQrBitmapCase {

    override fun invoke(width: Int, height: Int): Single<Bitmap> =
            loadQrStringCase.invoke()
                    .flatMap {
                        stringToQrBitmapCase(it, width = width, height = height)
                    }

}