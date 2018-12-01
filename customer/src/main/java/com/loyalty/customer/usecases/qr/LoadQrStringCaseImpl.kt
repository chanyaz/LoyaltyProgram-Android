package com.loyalty.customer.usecases.qr

import com.loyalty.customer.preferences.qr.QrPreferences
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class LoadQrStringCaseImpl(
        private val qrPreferences: QrPreferences
) : LoadQrStringCase {

    override fun loadQrString(): Single<String> =
            Single.just("Pidor")
                    .delay(3, TimeUnit.SECONDS)

}