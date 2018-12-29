package com.loyalty.customer.ui.models

import com.google.android.gms.maps.model.LatLng

data class VenuePageUIModel(
        val imageUrl: String,
        val name: String,
        val type: String,
        val venueOptions: List<VenueOptionUIModel>,
        val images: List<VenueImageUIModel>,
        val location: LatLng
)