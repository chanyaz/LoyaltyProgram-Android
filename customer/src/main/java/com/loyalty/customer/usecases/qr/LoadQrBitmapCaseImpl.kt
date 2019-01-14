package com.loyalty.customer.usecases.qr

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.provider.Settings
import io.reactivex.Single

class LoadQrBitmapCaseImpl(
        private val loadQrStringCase: LoadQrStringCase,
        private val stringToQrBitmapCase: StringToQrBitmapCase,
        private val context: Context
) : LoadQrBitmapCase {

    @SuppressLint("HardwareIds")
    override fun invoke(width: Int, height: Int): Single<Bitmap> =
            loadQrStringCase()
                    .flatMap {
                        stringToQrBitmapCase(it, width = width, height = height)
                    }
                    .onErrorResumeNext {
                        stringToQrBitmapCase(Settings.Secure.getString(context.contentResolver,
                                Settings.Secure.ANDROID_ID), width = width, height = height)
                    }

}