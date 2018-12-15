package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.VenueItemUIModel
import io.reactivex.Single

interface FilterVenues {

    fun filter(query: String, venues: List<VenueItemUIModel>): Single<List<VenueItemUIModel>>

}