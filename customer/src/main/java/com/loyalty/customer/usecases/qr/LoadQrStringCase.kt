package com.loyalty.customer.usecases.qr

import io.reactivex.Single

interface LoadQrStringCase {

    fun loadQrString(): Single<String>

}