package com.loyalty.customer.presentation.venues

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import com.loyalty.customer.presentation.navigation.CustomerScreens
import com.loyalty.customer.ui.models.VenueItemUIModel
import com.loyalty.customer.usecases.venues.FilterVenues
import com.loyalty.customer.usecases.venues.LoadVenues
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

class VenuesViewModelImpl(
        private val loadVenues: LoadVenues,
        private val filterVenues: FilterVenues
) : VenuesViewModel() {

    private val querySubject: BehaviorSubject<String> = BehaviorSubject.createDefault("")
    private var cachedVenues: List<VenueItemUIModel> = emptyList()

    override fun initViewModel() {
        setState(VenuesState())
        loadVenues()
    }

    private fun loadVenues() {
        subscribe(loadVenues.loadVenues()
                .flatMap { filterVenues.filter(querySubject.value!!, it) }
                .observeOnUi()
                .subscribe(::onLoadVenuesSuccess, ::onLoadVenuesError)
        )
    }

    private fun onLoadVenuesSuccess(venues: List<VenueItemUIModel>) {
        cachedVenues = venues
        setState(currentState.copy(venues = venues, isLoading = false, isError = false))
    }

    private fun onLoadVenuesError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

    override fun filterVenues(searchQuery: String) {
        querySubject.onNext(searchQuery)
        subscribe(filterVenues.filter(searchQuery, cachedVenues)
                .observeOnUi()
                .subscribeOrError("Error while filtering venue list") {
                    setState(currentState.copy(venues = it))
                }
        )
    }

    override fun selectVenue(position: Int) {
        router.navigateTo(CustomerScreens.KEY_VENUE.name)
    }

}