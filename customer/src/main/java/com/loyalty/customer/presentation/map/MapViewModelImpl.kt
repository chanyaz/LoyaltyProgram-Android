package com.loyalty.customer.presentation.map

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.venue.VenueMapUIModel
import com.loyalty.customer.usecases.map.LoadMapVenues
import timber.log.Timber

class MapViewModelImpl(
        private val loadMapVenues: LoadMapVenues
) : MapViewModel() {

    override val initialState: MapState get() = MapState()

    init {
        loadData()
    }

    private fun loadData() {
        subscribe(loadMapVenues()
                .observeOnUi()
                .subscribe(::onVenuesLoaded, ::onVenuesError)
        )
    }

    private fun onVenuesLoaded(venues: List<VenueMapUIModel>) {
        setState(currentState.copy(venues = venues, isVenueListLoaded = true))
    }

    private fun onVenuesError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isError = true))
    }

    override fun mapLoaded() {
        setState(currentState.copy(isMapLoaded = true))
    }

}