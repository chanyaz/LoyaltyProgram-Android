package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.base.BaseEvent

sealed class CoordinatorEvent : BaseEvent() {
    object UserLoggedIn : CoordinatorEvent()
    object UserNotLoggedIn : CoordinatorEvent()
}