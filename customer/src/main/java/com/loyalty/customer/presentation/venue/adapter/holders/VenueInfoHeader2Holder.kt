package com.loyalty.customer.presentation.venue.adapter.holders

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeader2UIModel
import kotlinx.android.synthetic.main.venue_info_header_2_item.view.venueInfoHeaderText

class VenueInfoHeader2Holder(itemView: View) : VenueInfoHolder<VenueInfoHeader2UIModel>(itemView) {

    private val title = itemView.venueInfoHeaderText

    override fun bind(model: VenueInfoHeader2UIModel) {
        title.text = model.title
    }

}