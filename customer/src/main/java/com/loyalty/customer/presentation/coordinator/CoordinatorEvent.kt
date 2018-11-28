package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.base.BaseEvent

sealed class CoordinatorEvent : BaseEvent() {
    data class CreateNavigation(val isUserLoggedIn: Boolean) : CoordinatorEvent()
}