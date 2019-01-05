package com.loyalty.customer.presentation.venue

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.customer.ui.models.VenuePageUIModel

data class VenuePageState(
        val model: VenuePageUIModel? = null,
        val isLoading: Boolean = true,
        val isError: Boolean = false
) : BaseState()