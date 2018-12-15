package com.loyalty.customer.ui.models

data class VenuePageUIModel(
        val imageUrl: String,
        val name: String,
        val type: String,
        val address: String,
        val workingHours: String,
        val phones: List<String>,
        val website: String,
        val latitude: Double,
        val longitude: Double
)