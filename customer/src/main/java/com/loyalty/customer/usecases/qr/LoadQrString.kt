package com.loyalty.customer.usecases.qr

import com.loyalty.core.util.UseCase
import com.loyalty.customer.preferences.qr.QrPreferences
import io.reactivex.Single

class LoadQrString(
        private val qrPreferences: QrPreferences
) : UseCase<Single<String>>() {

    override fun execute(): Single<String> =
            Single.just("Pidor")

}