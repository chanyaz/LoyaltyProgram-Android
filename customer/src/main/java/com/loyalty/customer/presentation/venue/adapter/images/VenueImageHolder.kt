package com.loyalty.customer.presentation.venue.adapter.images

import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleHolder
import kotlinx.android.synthetic.main.venue_image_item.view.venueImage

class VenueImageHolder(itemView: View) : SimpleHolder<String>(itemView) {

    private val venueImage = itemView.venueImage

    override fun bind(model: String) {
        Glide.with(itemView).load(model).into(venueImage)
    }

}