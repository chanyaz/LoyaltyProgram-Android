package com.loyalty.customer.ui.models

data class CardItemUIModel(
        val imageUrl: String,
        val venueName: String,
        val venueType: String,
        val daysLeft: Int,
        val eventDate: String,
        val eventType: EventType,
        val currentStamps: Int,
        val outOfStamps: Int
)