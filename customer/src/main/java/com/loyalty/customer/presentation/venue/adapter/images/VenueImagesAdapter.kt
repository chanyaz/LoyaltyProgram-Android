package com.loyalty.customer.presentation.venue.adapter.images

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.customer.ui.models.VenueImageUIModel

class VenueImagesAdapter : SimpleAdapter<VenueImageUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_image_item, parent, false)
        return VenueImageHolder(view)
    }

}