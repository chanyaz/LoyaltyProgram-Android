package com.loyalty.customer.presentation.venues

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import com.loyalty.customer.presentation.navigation.CustomerScreens
import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import com.loyalty.customer.usecases.venues.LoadVenues
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

class VenuesViewModelImpl(
        private val loadVenues: LoadVenues
) : VenuesViewModel() {

    override val initialState: VenuesState get() = VenuesState()

    private val querySubject: BehaviorSubject<String> = BehaviorSubject.createDefault("")
    private val venuesSubject: BehaviorSubject<List<VenueItemUIModel>> = BehaviorSubject.createDefault(emptyList())

    private val venuesObservable: Observable<List<VenueItemUIModel>> =
            Observable.combineLatest(querySubject, venuesSubject, BiFunction { query: String, venues: List<VenueItemUIModel> ->
                venues.filter { it.name.contains(query, true) || it.address.contains(query, true) }
            }).skip(1)

    init {
        loadData()
        subscribe(venuesObservable
                .subscribeOrError("Error while emitting venues") {
                    setState(currentState.copy(venues = it))
                })
    }

    private fun loadData() {
        subscribe(loadVenues()
                .observeOnUi()
                .subscribe(::onLoadVenuesSuccess, ::onLoadVenuesError)
        )
    }

    private fun onLoadVenuesSuccess(venues: List<VenueItemUIModel>) {
        setState(currentState.copy(isLoading = false))
        venuesSubject.onNext(venues)
    }

    private fun onLoadVenuesError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

    override fun filterVenues(searchQuery: String) {
        querySubject.onNext(searchQuery)
    }

    override fun selectVenue(position: Int) { /* todo need position of the filtered venue!!!!*/
        router.hideNAdd(CustomerScreens.KEY_VENUE_PAGE.name)
    }

    override fun openSearch() {
        setState(currentState.copy(isSearchOpen = true))
    }

    override fun closeSearch() {
        setState(currentState.copy(isSearchOpen = false))
    }
}