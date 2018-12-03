package com.loyalty.customer.network.api

import com.loyalty.customer.ui.models.VenueUIModel
import io.reactivex.Single

interface VenuesApi {

    fun getVenuesVersion(city: String): Single<Long>

    fun getVenues(city: String): Single<List<VenueUIModel>>

}