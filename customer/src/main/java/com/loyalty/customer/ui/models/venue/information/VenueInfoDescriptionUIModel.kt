package com.loyalty.customer.ui.models.venue.information

data class VenueInfoDescriptionUIModel(val description: String) : VenueInfoUIModel {

    override val id: Any get() = description

}