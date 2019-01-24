package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.coordinator.FlowEvent

data class CustomerFlowEvent(val isUserLoggedIn: Boolean) : FlowEvent()