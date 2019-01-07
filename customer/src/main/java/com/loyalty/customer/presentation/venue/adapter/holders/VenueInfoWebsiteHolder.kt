package com.loyalty.customer.presentation.venue.adapter.holders

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoWebsiteUIModel
import kotlinx.android.synthetic.main.venue_info_website_item.view.venueInfoWebsite

class VenueInfoWebsiteHolder(itemView: View) : VenueInfoHolder<VenueInfoWebsiteUIModel>(itemView) {

    private val website = itemView.venueInfoWebsite

    override fun bind(model: VenueInfoWebsiteUIModel) {
        website.text = model.website
    }

}