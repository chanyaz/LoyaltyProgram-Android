package com.loyalty.customer.presentation.venue

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.util.SingleEventFlag
import com.loyalty.customer.ui.models.venue.VenuePageUIModel

data class VenuePageState(
        val model: VenuePageUIModel? = null,
        val areToolbarTitlesShown: Boolean = false,
        val shouldDrawMap: SingleEventFlag = SingleEventFlag(false),
        val isLoading: Boolean = true,
        val isError: Boolean = false
) : BaseState()