package com.loyalty.customer.presentation.venue

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.VenuePageUIModel
import com.loyalty.customer.usecases.venue.LoadVenuePage
import timber.log.Timber

class VenueViewModelImpl(
        private val loadVenuePage: LoadVenuePage
) : VenueViewModel() {

    override fun initViewModel() {
        setState(VenueState())
        loadVenue()
    }

    private fun loadVenue() {
        subscribe(loadVenuePage("")
                .observeOnUi()
                .subscribe(::onLoadVenueSuccess, ::onLoadVenueError)
        )
    }

    private fun onLoadVenueSuccess(venue: VenuePageUIModel) {
        setState(currentState.copy(model = venue, isLoading = false, isError = false))
    }

    private fun onLoadVenueError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

}