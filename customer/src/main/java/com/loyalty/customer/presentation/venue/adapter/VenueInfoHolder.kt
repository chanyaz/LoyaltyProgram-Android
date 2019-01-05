package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

abstract class VenueInfoHolder<T : VenueInfoUIModel>(itemView: View) : SimpleHolder<T>(itemView)