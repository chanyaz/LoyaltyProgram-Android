package com.loyalty.customer.usecases.venues

import com.loyalty.customer.preferences.location.LocationPreferences
import com.loyalty.customer.repository.venues.VenuesRepository
import com.loyalty.customer.ui.models.VenueItemUIModel
import io.reactivex.Single

class LoadVenuesImpl(
        private val venuesRepository: VenuesRepository,
        private val locationPreferences: LocationPreferences
) : LoadVenues {

    override fun invoke(): Single<List<VenueItemUIModel>> =
            locationPreferences.getCurrentLocation()
                    .flatMap { venuesRepository.getVenues(it) }

}