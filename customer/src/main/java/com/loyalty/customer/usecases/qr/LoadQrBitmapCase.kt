package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import io.reactivex.Single

interface LoadQrBitmapCase {

    fun loadQrBitmap(width: Int, height: Int): Single<Bitmap>

}