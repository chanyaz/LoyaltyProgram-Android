package com.loyalty.customer.ui.models.venue.information

import android.support.annotation.DrawableRes

data class VenueInfoHeaderUIModel(val title: String, @DrawableRes val imageRes: Int) : VenueInfoUIModel {

    override val id: Any get() = title

}