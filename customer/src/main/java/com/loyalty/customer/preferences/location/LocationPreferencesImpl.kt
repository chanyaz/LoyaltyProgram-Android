package com.loyalty.customer.preferences.location

import android.content.Context
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class LocationPreferencesImpl(
        context: Context,
        io: Scheduler
) : RxPreferences(context, Consts.LOCATION_PREFERENCES, io), LocationPreferences {

    override fun saveCurrentLocation(currentLocation: String): Completable =
            saveString(KEY_CURRENT_LOCATION, currentLocation)

    override fun getCurrentLocation(): Single<String> =
            getString(KEY_CURRENT_LOCATION)

    companion object {
        private const val KEY_CURRENT_LOCATION = "KEY_CURRENT_LOCATION"
    }

}