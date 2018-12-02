package com.loyalty.customer.preferences.venuesversion

import android.content.Context
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class VenuesVPreferencesImpl(
        context: Context,
        io: Scheduler
) : RxPreferences(context, Consts.VENUES_V_PREFERENCES, io), VenuesVPreferences {

    override fun saveVenuesVersion(version: Long, city: String): Completable = saveLong(city, version)

    override fun getVenuesVersion(city: String): Single<Long> = getLong(city)

}