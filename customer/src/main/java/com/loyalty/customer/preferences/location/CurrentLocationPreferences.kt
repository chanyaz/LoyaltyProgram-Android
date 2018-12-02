package com.loyalty.customer.preferences.location

import io.reactivex.Completable
import io.reactivex.Single

interface CurrentLocationPreferences {

    fun saveCurrentLocation(currentLocation: String): Completable

    fun getCurrentLocation(): Single<String>

}