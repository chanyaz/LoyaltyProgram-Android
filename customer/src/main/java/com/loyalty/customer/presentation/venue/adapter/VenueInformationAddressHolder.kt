package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.VenueInformationAddressUIModel
import kotlinx.android.synthetic.main.venue_information_address_item.view.venueInformationAddress

class VenueInformationAddressHolder(itemView: View) : VenueInformationHolder<VenueInformationAddressUIModel>(itemView) {

    private val address = itemView.venueInformationAddress

    override fun bind(model: VenueInformationAddressUIModel) {
        address.text = model.address
    }

}