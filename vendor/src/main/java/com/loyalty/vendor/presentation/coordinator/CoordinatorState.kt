package com.loyalty.vendor.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState

data class CoordinatorState(val isUserLoggedIn: Boolean) : BaseState()