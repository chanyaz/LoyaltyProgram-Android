package com.loyalty.customer.ui.models.venue.information

data class VenueInfoAddressUIModel(val address: String) : VenueInfoUIModel {

    override val id: Any get() = address

}