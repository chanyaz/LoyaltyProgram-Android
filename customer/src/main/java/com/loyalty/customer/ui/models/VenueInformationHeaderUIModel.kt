package com.loyalty.customer.ui.models

import android.support.annotation.DrawableRes

class VenueInformationHeaderUIModel(val title: String, @DrawableRes val imageRes: Int) : VenueInformationUIModel {

    override val id: Any get() = title

}