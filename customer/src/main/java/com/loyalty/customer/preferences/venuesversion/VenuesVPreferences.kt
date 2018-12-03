package com.loyalty.customer.preferences.venuesversion

import io.reactivex.Completable
import io.reactivex.Single

interface VenuesVPreferences {

    fun saveVenuesVersion(city: String, version: Long): Completable

    fun getVenuesVersion(city: String): Single<Long>

}