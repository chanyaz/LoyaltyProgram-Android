package com.loyalty.customer.ui.models.venue.information

data class VenueInfoPhoneUIModel(val phone: String) : VenueInfoUIModel {

    override val id: Any get() = phone

}