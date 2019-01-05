package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeaderUIModel
import kotlinx.android.synthetic.main.venue_info_header_item.view.venueInfoHeaderIcon
import kotlinx.android.synthetic.main.venue_info_header_item.view.venueInfoHeaderText

class VenueInfoHeaderHolder(itemView: View) : VenueInfoHolder<VenueInfoHeaderUIModel>(itemView) {

    private val title = itemView.venueInfoHeaderText
    private val icon = itemView.venueInfoHeaderIcon

    override fun bind(model: VenueInfoHeaderUIModel) {
        title.text = model.title
        icon.setImageResource(model.imageRes)
    }

}