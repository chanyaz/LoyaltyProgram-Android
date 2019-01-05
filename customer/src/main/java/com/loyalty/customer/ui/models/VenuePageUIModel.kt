package com.loyalty.customer.ui.models

import com.google.android.gms.maps.model.LatLng

data class VenuePageUIModel(
        val name: String,
        val type: String,
        val imageUrls: List<String>,
        val cards: List<CardItemUIModel>,
        val addresses: List<VenueInformationAddressUIModel>,
        val schedules: List<VenueInformationScheduleUIModel>,
        val phones: List<VenueInformationPhoneUIModel>,
        val website: List<VenueInformationWebsiteUIModel>,
        val description: String,
        val location: LatLng
)