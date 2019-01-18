package com.loyalty.customer.usecases.map

import com.loyalty.customer.ui.models.venue.VenueMapUIModel
import io.reactivex.Single

interface LoadMapVenues {

    operator fun invoke(): Single<List<VenueMapUIModel>>

}