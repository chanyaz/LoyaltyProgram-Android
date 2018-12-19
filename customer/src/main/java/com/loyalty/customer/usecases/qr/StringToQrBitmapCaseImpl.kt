package com.loyalty.customer.usecases.qr

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import io.reactivex.Scheduler
import io.reactivex.Single

class StringToQrBitmapCaseImpl(
        private val computation: Scheduler
) : StringToQrBitmapCase {

    override fun invoke(qrString: String, width: Int, height: Int): Single<Bitmap> =
            Single.just(qrString)
                    .subscribeOn(computation)
                    .map {
                        BarcodeEncoder().encodeBitmap(
                                it,
                                BarcodeFormat.QR_CODE,
                                width,
                                height
                        )
                    }
                    .onErrorReturn {
                        Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
                    }

}