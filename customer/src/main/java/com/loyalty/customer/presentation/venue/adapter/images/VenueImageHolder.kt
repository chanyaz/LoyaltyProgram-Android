package com.loyalty.customer.presentation.venue.adapter.images

import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.ui.models.VenueImageUIModel
import kotlinx.android.synthetic.main.venue_image_item.view.venueImage

class VenueImageHolder(itemView: View) : SimpleHolder<VenueImageUIModel>(itemView) {

    private val venueImage = itemView.venueImage

    override fun bind(model: VenueImageUIModel) {
        Glide.with(itemView).load(model.imageUrl).into(venueImage)
    }

}