package com.loyalty.customer.ui.models

import com.loyalty.core.ui.adapter.SimpleRecyclerModel

data class VenueImageUIModel(val imageUrl: String) : SimpleRecyclerModel {

    override val id: Any get() = imageUrl

}