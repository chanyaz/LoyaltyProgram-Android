package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.customer.ui.models.venue.VenueItemUIModel

data class VenuesState(
        val venues: List<VenueItemUIModel> = emptyList(),
        val isLoading: Boolean = true,
        val isError: Boolean = false
) : BaseState()