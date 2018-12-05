package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.preferences.location.LocationPreferences
import com.loyalty.customer.repository.venues.VenuesRepository

class VenuesViewModel(
        private val venuesRepository: VenuesRepository,
        private val locationPreferences: LocationPreferences
) : BaseViewModel<VenuesState, VenuesEvent>() {

    fun initViewModel() {
        setState(VenuesState.VenuesLoading)
        loadVenues()
    }

    private fun loadVenues() {
        subscribe(locationPreferences.getCurrentLocation()
                .flatMap { venuesRepository.getVenues(it) }
                .observeOnUi()
                .subscribe({
                    setState(if (it.isEmpty()) VenuesState.VenuesEmpty else VenuesState.VenuesLoaded(it))
                }, {
                    setState(VenuesState.VenuesError)
                }))
    }

}