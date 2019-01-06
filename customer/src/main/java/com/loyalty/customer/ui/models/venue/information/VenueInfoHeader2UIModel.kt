package com.loyalty.customer.ui.models.venue.information

data class VenueInfoHeader2UIModel(val title: String) : VenueInfoUIModel {

    override val id: Any get() = title

}