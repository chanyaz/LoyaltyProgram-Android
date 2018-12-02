package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.base.BaseEvent

sealed class VenuesEvent : BaseEvent() {
    object SearchClicked : VenuesEvent()
    data class VenueClicked(val position: VenueClicked) : VenuesEvent()
}