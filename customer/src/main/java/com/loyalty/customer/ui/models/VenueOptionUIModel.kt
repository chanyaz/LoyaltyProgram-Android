package com.loyalty.customer.ui.models

import android.content.Intent
import android.support.annotation.DrawableRes
import com.loyalty.core.ui.adapter.SimpleRecyclerModel

data class VenueOptionUIModel(
        @DrawableRes val iconRes: Int,
        val title: String,
        val intent: Intent?
) : SimpleRecyclerModel {

    override val id: Any get() = title

}