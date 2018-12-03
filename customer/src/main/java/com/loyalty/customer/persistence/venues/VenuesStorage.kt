package com.loyalty.customer.persistence.venues

import com.loyalty.customer.ui.models.VenueUIModel
import io.reactivex.Completable
import io.reactivex.Single

interface VenuesStorage {

    fun getVenues(city: String): Single<List<VenueUIModel>>

    fun saveVenues(city: String, venues: List<VenueUIModel>): Completable

    fun clearVenues(city: String): Completable

}