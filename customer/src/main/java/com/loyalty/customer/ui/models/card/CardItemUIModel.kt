package com.loyalty.customer.ui.models.card

import com.loyalty.core.ui.adapter.SimpleRecyclerModel

data class CardItemUIModel(
        val imageUrl: String,
        val venueName: String,
        val venueType: String,
        val daysLeft: Int,
        val eventDate: String,
        val eventType: EventType,
        val currentStamps: Int,
        val outOfStamps: Int,
        val isExpandedState: Boolean = false
) : SimpleRecyclerModel {

    override val id: Any get() = venueName

}