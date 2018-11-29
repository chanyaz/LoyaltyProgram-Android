package com.loyalty.customer.preferences.qr

import io.reactivex.Completable
import io.reactivex.Single

interface QrPreferences {

    fun saveQrCode(qrString: String): Completable

    fun getQrCode(): Single<String>

}