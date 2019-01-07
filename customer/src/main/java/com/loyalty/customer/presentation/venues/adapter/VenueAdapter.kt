package com.loyalty.customer.presentation.venues.adapter

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.loyalty.core.ui.adapter.SimpleDelegationAdapter
import com.loyalty.customer.presentation.venues.adapter.delegates.VenueDelegate
import com.loyalty.customer.ui.models.venue.VenueItemUIModel

class VenueAdapter(
        private val onVenueClicked: (Int) -> Unit
) : SimpleDelegationAdapter<VenueItemUIModel>(
        AdapterDelegatesManager<List<VenueItemUIModel>>().apply {
            addDelegate(VenueDelegate(onVenueClicked))
        }
)