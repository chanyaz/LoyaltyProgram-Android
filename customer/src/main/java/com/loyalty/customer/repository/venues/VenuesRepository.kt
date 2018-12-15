package com.loyalty.customer.repository.venues

import com.loyalty.customer.ui.models.VenueItemUIModel
import io.reactivex.Single

interface VenuesRepository {

    fun getVenues(city: String): Single<List<VenueItemUIModel>>

}