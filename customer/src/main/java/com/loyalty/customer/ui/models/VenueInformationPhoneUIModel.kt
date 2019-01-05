package com.loyalty.customer.ui.models

data class VenueInformationPhoneUIModel(val phone: String) : VenueInformationUIModel {

    override val id: Any get() = phone

}