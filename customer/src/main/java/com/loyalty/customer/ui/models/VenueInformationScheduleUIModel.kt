package com.loyalty.customer.ui.models

data class VenueInformationScheduleUIModel(val day: String, val hours: String) : VenueInformationUIModel {

    override val id: Any get() = day

}