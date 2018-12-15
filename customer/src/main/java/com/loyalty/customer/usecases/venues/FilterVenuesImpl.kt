package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.VenueUIModel
import io.reactivex.Scheduler
import io.reactivex.Single

class FilterVenuesImpl(
        private val computation: Scheduler
) : FilterVenues {

    override fun filter(query: String, venues: List<VenueUIModel>): Single<List<VenueUIModel>> =
            Single.just(venues)
                    .map { list ->
                        list.filter { it.name.contains(query, true) || it.address.contains(query, true) }
                    }
                    .subscribeOn(computation)

}