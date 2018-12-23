package com.loyalty.customer.presentation.venue.adapter.images

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.core.ui.adapter.SimpleAdapter

class VenueImagesAdapter : SimpleAdapter<String>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_image_item, parent, false)
        return VenueImageHolder(view)
    }

}