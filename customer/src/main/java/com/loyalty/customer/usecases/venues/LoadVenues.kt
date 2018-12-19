package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.VenueItemUIModel
import io.reactivex.Single

interface LoadVenues {

    operator fun invoke(): Single<List<VenueItemUIModel>>

}