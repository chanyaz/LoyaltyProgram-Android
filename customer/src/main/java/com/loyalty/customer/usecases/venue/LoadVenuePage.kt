package com.loyalty.customer.usecases.venue

import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import io.reactivex.Single

interface LoadVenuePage {

    operator fun invoke(id: String): Single<VenuePageUIModel>

}