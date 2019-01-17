package com.loyalty.customer.ui.models.venue

import com.loyalty.core.ui.adapter.SimpleRecyclerModel

data class VenueItemUIModel(
        val imageUrl: String,
        val name: String,
        val address: String,
        val distance: Double?,
        val workingHours: String
): SimpleRecyclerModel {

    override val id: Any get() = name

}