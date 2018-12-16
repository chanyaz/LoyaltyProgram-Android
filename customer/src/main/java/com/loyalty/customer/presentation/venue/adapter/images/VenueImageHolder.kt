package com.loyalty.customer.presentation.venue.adapter.images

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.venue_image_item.view.venueImage

class VenueImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val venueImage = itemView.venueImage

    fun bind(url: String) {
        Glide.with(itemView).load(url).into(venueImage)
    }

}