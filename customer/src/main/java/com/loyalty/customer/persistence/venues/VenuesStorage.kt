package com.loyalty.customer.persistence.venues

import com.loyalty.customer.ui.models.VenueItemUIModel
import io.reactivex.Completable
import io.reactivex.Single

interface VenuesStorage {

    fun getVenues(city: String): Single<List<VenueItemUIModel>>

    fun saveVenues(city: String, venues: List<VenueItemUIModel>): Completable

    fun clearVenues(city: String): Completable

}