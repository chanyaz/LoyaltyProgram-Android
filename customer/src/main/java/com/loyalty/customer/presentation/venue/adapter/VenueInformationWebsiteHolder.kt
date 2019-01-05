package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.VenueInformationWebsiteUIModel
import kotlinx.android.synthetic.main.venue_information_website_item.view.venueInformationWebsite

class VenueInformationWebsiteHolder(itemView: View) : VenueInformationHolder<VenueInformationWebsiteUIModel>(itemView) {

    private val website = itemView.venueInformationWebsite

    override fun bind(model: VenueInformationWebsiteUIModel) {
        website.text = model.website
    }

}