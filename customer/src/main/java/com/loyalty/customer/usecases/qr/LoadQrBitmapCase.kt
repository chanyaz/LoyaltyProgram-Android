package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import io.reactivex.Single

interface LoadQrBitmapCase {

    operator fun invoke(width: Int, height: Int): Single<Bitmap>

}