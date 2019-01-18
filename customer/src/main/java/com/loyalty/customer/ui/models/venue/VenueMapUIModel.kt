package com.loyalty.customer.ui.models.venue

import com.google.android.gms.maps.model.LatLng

data class VenueMapUIModel(
        val id: String = "",
        val name: String,
        val type: String,
        val distance: Double?,
        val location: LatLng,
        var isSelected: Boolean = false
)