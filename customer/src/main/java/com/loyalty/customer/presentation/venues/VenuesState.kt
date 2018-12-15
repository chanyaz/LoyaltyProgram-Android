package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.customer.ui.models.VenueItemUIModel

sealed class VenuesState : BaseState() {
    object VenuesEmpty : VenuesState()
    object VenuesLoading : VenuesState()
    object VenuesError : VenuesState()
    data class VenuesLoaded(val venues: List<VenueItemUIModel>) : VenuesState()
}