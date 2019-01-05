package com.loyalty.customer.ui.models.venue.information

data class VenueInfoWebsiteUIModel(val website: String) : VenueInfoUIModel {

    override val id: Any get() = website

}