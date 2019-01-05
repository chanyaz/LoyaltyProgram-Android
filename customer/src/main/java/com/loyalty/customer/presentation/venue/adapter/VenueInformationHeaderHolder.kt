package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.VenueInformationHeaderUIModel
import kotlinx.android.synthetic.main.venue_information_header_item.view.venueInformationHeaderIcon
import kotlinx.android.synthetic.main.venue_information_header_item.view.venueInformationHeaderText

class VenueInformationHeaderHolder(itemView: View) : VenueInformationHolder<VenueInformationHeaderUIModel>(itemView) {

    private val title = itemView.venueInformationHeaderText
    private val icon = itemView.venueInformationHeaderIcon

    override fun bind(model: VenueInformationHeaderUIModel) {
        title.text = model.title
        icon.setImageResource(model.imageRes)
    }

}