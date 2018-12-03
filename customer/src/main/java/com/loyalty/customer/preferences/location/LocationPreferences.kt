package com.loyalty.customer.preferences.location

import io.reactivex.Completable
import io.reactivex.Single

interface LocationPreferences {

    fun saveCurrentLocation(currentLocation: String): Completable

    fun getCurrentLocation(): Single<String>

}