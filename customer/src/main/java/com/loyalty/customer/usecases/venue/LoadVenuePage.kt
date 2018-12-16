package com.loyalty.customer.usecases.venue

import com.loyalty.customer.ui.models.VenuePageUIModel
import io.reactivex.Single

interface LoadVenuePage {

    fun loadVenuePage(id: String): Single<VenuePageUIModel>

}