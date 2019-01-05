package com.loyalty.customer.ui.models

data class VenueInformationAddressUIModel(val address: String) : VenueInformationUIModel {

    override val id: Any get() = address

}