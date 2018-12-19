package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import io.reactivex.Single

interface StringToQrBitmapCase {

    operator fun invoke(qrString: String, width: Int, height: Int): Single<Bitmap>

}