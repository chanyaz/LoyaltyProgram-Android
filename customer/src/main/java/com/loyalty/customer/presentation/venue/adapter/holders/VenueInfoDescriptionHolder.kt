package com.loyalty.customer.presentation.venue.adapter.holders

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoDescriptionUIModel
import kotlinx.android.synthetic.main.venue_info_description_item.view.venueInfoDescriptionText

class VenueInfoDescriptionHolder(itemView: View) : VenueInfoHolder<VenueInfoDescriptionUIModel>(itemView) {

    private val title = itemView.venueInfoDescriptionText

    override fun bind(model: VenueInfoDescriptionUIModel) {
        title.text = model.description
    }

}