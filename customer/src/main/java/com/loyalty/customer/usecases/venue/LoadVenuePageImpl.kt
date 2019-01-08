package com.loyalty.customer.usecases.venue

import com.loyalty.customer.repository.venuepage.VenuePageRepository
import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoadVenuePageImpl(
        private val venuePageRepository: VenuePageRepository
) : LoadVenuePage {

    override fun invoke(id: String): Single<VenuePageUIModel> =
            venuePageRepository.loadVenuePage("lol")
                    .delay(500, TimeUnit.MILLISECONDS, Schedulers.io())

}