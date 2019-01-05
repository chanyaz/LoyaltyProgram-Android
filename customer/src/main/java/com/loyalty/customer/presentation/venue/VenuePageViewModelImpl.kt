package com.loyalty.customer.presentation.venue

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.VenuePageUIModel
import com.loyalty.customer.usecases.venue.LoadVenuePage
import timber.log.Timber

class VenuePageViewModelImpl(
        private val loadVenuePage: LoadVenuePage
) : VenuePageViewModel() {

    override fun initViewModel() {
        setState(VenuePageState())
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

    override fun mapLoaded() {
        setState(currentState.copy())
    }

    override fun back() {
        router.backNShow()
    }

}