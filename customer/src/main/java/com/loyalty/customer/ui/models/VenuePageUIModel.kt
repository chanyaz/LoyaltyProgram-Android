package com.loyalty.customer.ui.models

data class VenuePageUIModel(
        val imageUrl: String,
        val name: String,
        val type: String,
        val venueOptions: List<VenueOptionUIModel>,
        val images: List<String>,
        val latitude: Double,
        val longitude: Double
)