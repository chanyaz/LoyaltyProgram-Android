package com.loyalty.customer.usecases.qr

import com.loyalty.customer.preferences.qr.QrPreferences
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class LoadQrStringCaseImpl(
        private val qrPreferences: QrPreferences
) : LoadQrStringCase {

    override fun invoke(): Single<String> =
            Single.error<String>(RuntimeException("Not possible to load qr code"))
                    .delay(500, TimeUnit.MILLISECONDS)

}