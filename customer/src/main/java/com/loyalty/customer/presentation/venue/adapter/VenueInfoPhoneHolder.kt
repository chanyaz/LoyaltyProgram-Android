package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoPhoneUIModel
import kotlinx.android.synthetic.main.venue_info_phone_item.view.venueInfoPhone

class VenueInfoPhoneHolder(itemView: View) : VenueInfoHolder<VenueInfoPhoneUIModel>(itemView) {

    private val phone = itemView.venueInfoPhone

    override fun bind(model: VenueInfoPhoneUIModel) {
        phone.text = model.phone
    }

}