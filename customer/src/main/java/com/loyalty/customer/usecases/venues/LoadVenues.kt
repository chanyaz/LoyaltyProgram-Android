package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import io.reactivex.Single

interface LoadVenues {

    operator fun invoke(): Single<List<VenueItemUIModel>>

}