package com.loyalty.customer.usecases.venues

import com.loyalty.customer.ui.models.VenueUIModel
import io.reactivex.Single

interface LoadVenues {

    fun loadVenues(): Single<List<VenueUIModel>>

}