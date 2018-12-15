package com.loyalty.customer.presentation.venues

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.usecases.venues.FilterVenues
import com.loyalty.customer.usecases.venues.LoadVenues

class VenuesViewModelImpl(
        private val loadVenues: LoadVenues,
        private val filterVenues: FilterVenues
) : VenuesViewModel() {

    override fun initViewModel() {
        setState(VenuesState.VenuesLoading)
        loadVenues()
    }

    private fun loadVenues() {
        subscribe(loadVenues.loadVenues()
                .observeOnUi()
                .subscribe({
                    setState(if (it.isEmpty()) VenuesState.VenuesEmpty else VenuesState.VenuesLoaded(it))
                }, {
                    setState(VenuesState.VenuesError)
                }))
    }

    override fun filterVenues(query: String) {
        val venues = (stateSubject.value as? VenuesState.VenuesLoaded)?.venues ?: return

        subscribe(filterVenues.filter(query, venues)
                .observeOnUi()
                .subscribe({
                    setState(if (it.isEmpty()) VenuesState.VenuesEmpty else VenuesState.VenuesLoaded(it))
                }, {
                    setState(VenuesState.VenuesError)
                })
        )
    }

}