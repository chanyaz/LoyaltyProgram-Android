package com.loyalty.customer.presentation.map

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.customer.ui.models.venue.VenueMapUIModel

data class MapState(
        val venues: List<VenueMapUIModel> = emptyList(),
        val isVenueListLoaded: Boolean = false,
        val isMapLoaded: Boolean = false,
        val isError: Boolean = false
) : BaseState()