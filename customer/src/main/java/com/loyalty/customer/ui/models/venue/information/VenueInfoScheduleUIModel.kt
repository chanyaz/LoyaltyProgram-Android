package com.loyalty.customer.ui.models.venue.information

data class VenueInfoScheduleUIModel(val day: String, val hours: String) : VenueInfoUIModel {

    override val id: Any get() = day

}