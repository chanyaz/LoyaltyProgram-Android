package com.loyalty.customer.ui.models.venue

import com.google.android.gms.maps.model.LatLng
import com.loyalty.customer.ui.models.card.CardItemUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

data class VenuePageUIModel(
        val name: String,
        val type: String,
        val imageUrls: List<String>,
        val cards: List<CardItemUIModel>,
        val venueInfoListUIModel: List<VenueInfoUIModel>,
//        val addresses: List<VenueInfoAddressUIModel>,
//        val schedules: List<VenueInfoScheduleUIModel>,
//        val phones: List<VenueInfoPhoneUIModel>,
//        val website: List<VenueInfoWebsiteUIModel>,
        val description: String,
        val location: LatLng
)