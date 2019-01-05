package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.VenueInformationPhoneUIModel
import kotlinx.android.synthetic.main.venue_information_phone_item.view.venueInformationPhone

class VenueInformationPhoneHolder(itemView: View) : VenueInformationHolder<VenueInformationPhoneUIModel>(itemView) {

    private val phone = itemView.venueInformationPhone

    override fun bind(model: VenueInformationPhoneUIModel) {
        phone.text = model.phone
    }

}