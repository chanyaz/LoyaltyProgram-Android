package com.loyalty.customer.presentation.venue.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueInformationAddressUIModel
import com.loyalty.customer.ui.models.VenueInformationHeaderUIModel
import com.loyalty.customer.ui.models.VenueInformationPhoneUIModel
import com.loyalty.customer.ui.models.VenueInformationScheduleUIModel
import com.loyalty.customer.ui.models.VenueInformationSeparatorUIModel
import com.loyalty.customer.ui.models.VenueInformationUIModel
import com.loyalty.customer.ui.models.VenueInformationWebsiteUIModel

class VenueInformationAdapter : SimpleAdapter<VenueInformationUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueInformationHolder<VenueInformationUIModel> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.venue_information_address_item -> VenueInformationAddressHolder(view)
            R.layout.venue_information_header_item -> VenueInformationHeaderHolder(view)
            R.layout.venue_information_phone_item -> VenueInformationPhoneHolder(view)
            R.layout.venue_information_schedule_item -> VenueInformationScheduleHolder(view)
            R.layout.venue_information_website_item -> VenueInformationWebsiteHolder(view)
            R.layout.venue_information_separator -> VenueInformationSeparatorHolder(view)
            else -> throw RuntimeException("Such ViewHolder does not exist")
        } as VenueInformationHolder<VenueInformationUIModel>
    }

    override fun getItemViewType(position: Int): Int =
            when (elements[position]) {
                is VenueInformationAddressUIModel -> R.layout.venue_information_address_item
                is VenueInformationHeaderUIModel -> R.layout.venue_information_header_item
                is VenueInformationPhoneUIModel -> R.layout.venue_information_phone_item
                is VenueInformationScheduleUIModel -> R.layout.venue_information_schedule_item
                is VenueInformationWebsiteUIModel -> R.layout.venue_information_website_item
                is VenueInformationSeparatorUIModel -> R.layout.venue_information_separator
                else -> throw RuntimeException("Such UI model does not exist")
            }.exhaustive

}