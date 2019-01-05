package com.loyalty.customer.ui.models

data class VenueInformationWebsiteUIModel(val website: String) : VenueInformationUIModel {

    override val id: Any get() = website

}