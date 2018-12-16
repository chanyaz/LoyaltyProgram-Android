package com.loyalty.customer.usecases.venue

import com.loyalty.customer.repository.venuepage.VenuePageRepository
import com.loyalty.customer.ui.models.VenuePageUIModel
import io.reactivex.Single

class LoadVenuePageImpl(
        private val venuePageRepository: VenuePageRepository
) : LoadVenuePage {

    override fun loadVenuePage(id: String): Single<VenuePageUIModel> =
            venuePageRepository.loadVenuePage("lol")

}