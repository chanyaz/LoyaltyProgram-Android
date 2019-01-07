package com.loyalty.customer.presentation.venue.adapter.holders

import android.view.View
import com.loyalty.core.ui.adapter.SimpleDelegationHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

abstract class VenueInfoHolder<T : VenueInfoUIModel>(itemView: View) : SimpleDelegationHolder<T>(itemView)