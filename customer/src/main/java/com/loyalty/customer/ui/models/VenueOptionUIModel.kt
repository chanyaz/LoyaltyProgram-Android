package com.loyalty.customer.ui.models

import android.content.Intent
import android.support.annotation.DrawableRes

data class VenueOptionUIModel(
        @DrawableRes val iconRes: Int,
        val title: String,
        val intent: Intent?
)