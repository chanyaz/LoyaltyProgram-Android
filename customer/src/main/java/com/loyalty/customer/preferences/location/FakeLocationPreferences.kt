package com.loyalty.customer.preferences.location

import android.content.Context
import com.loyalty.core.storage.preferences.RxPreferences
import com.loyalty.customer.Consts
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class FakeLocationPreferences(
        context: Context,
        io: Scheduler
) : RxPreferences(context, Consts.LOCATION_PREFERENCES, io), LocationPreferences {

    override fun saveCurrentLocation(currentLocation: String): Completable =
            Completable.complete()

    override fun getCurrentLocation(): Single<String> =
            Single.just("Minsk")
                    .delay(300, TimeUnit.MILLISECONDS, io)

}