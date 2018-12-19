package com.loyalty.customer.usecases.qr

import io.reactivex.Single

interface LoadQrStringCase {

    operator fun invoke(): Single<String>

}