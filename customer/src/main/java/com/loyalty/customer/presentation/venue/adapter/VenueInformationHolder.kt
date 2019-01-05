package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.ui.models.VenueInformationUIModel

abstract class VenueInformationHolder<T : VenueInformationUIModel>(itemView: View) : SimpleHolder<T>(itemView)