package com.loyalty.customer.usecases.qr

import com.loyalty.customer.preferences.qr.QrPreferences
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoadQrStringCaseImpl(
        private val qrPreferences: QrPreferences
) : LoadQrStringCase {

    override fun invoke(): Single<String> =
            Single.just("test")
                    .cache()
                    .delay(3000, TimeUnit.MILLISECONDS, Schedulers.io())

}