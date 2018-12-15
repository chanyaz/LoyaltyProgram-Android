package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.VenueUIModel
import io.reactivex.Single

interface FilterVenues {

    fun filter(query: String, venues: List<VenueUIModel>): Single<List<VenueUIModel>>

}