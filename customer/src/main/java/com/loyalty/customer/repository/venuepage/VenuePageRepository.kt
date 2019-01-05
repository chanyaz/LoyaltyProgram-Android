package com.loyalty.customer.repository.venuepage

import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import io.reactivex.Single

interface VenuePageRepository {

    fun loadVenuePage(id: String): Single<VenuePageUIModel>

}