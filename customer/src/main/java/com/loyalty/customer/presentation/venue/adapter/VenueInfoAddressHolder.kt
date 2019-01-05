package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import kotlinx.android.synthetic.main.venue_info_address_item.view.venueInfoAddress

class VenueInfoAddressHolder(itemView: View) : VenueInfoHolder<VenueInfoAddressUIModel>(itemView) {

    private val address = itemView.venueInfoAddress

    override fun bind(model: VenueInfoAddressUIModel) {
        address.text = model.address
    }

}