package com.loyalty.customer.presentation.venue.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoDescriptionUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeader2UIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeaderUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoPhoneUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoScheduleUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoSeparatorUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoWebsiteUIModel

class VenueInfoAdapter : SimpleAdapter<VenueInfoUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueInfoHolder<VenueInfoUIModel> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.venue_info_address_item -> VenueInfoAddressHolder(view)
            R.layout.venue_info_header_item -> VenueInfoHeaderHolder(view)
            R.layout.venue_info_phone_item -> VenueInfoPhoneHolder(view)
            R.layout.venue_info_schedule_item -> VenueInfoScheduleHolder(view)
            R.layout.venue_info_website_item -> VenueInfoWebsiteHolder(view)
            R.layout.venue_info_separator_item -> VenueInfoSeparatorHolder(view)
            R.layout.venue_info_header_2_item -> VenueInfoHeader2Holder(view)
            R.layout.venue_info_description_item -> VenueInfoDescriptionHolder(view)
            else -> throw RuntimeException("Such ViewHolder does not exist")
        } as VenueInfoHolder<VenueInfoUIModel>
    }

    override fun getItemViewType(position: Int): Int =
            when (elements[position]) {
                is VenueInfoAddressUIModel -> R.layout.venue_info_address_item
                is VenueInfoHeaderUIModel -> R.layout.venue_info_header_item
                is VenueInfoPhoneUIModel -> R.layout.venue_info_phone_item
                is VenueInfoScheduleUIModel -> R.layout.venue_info_schedule_item
                is VenueInfoWebsiteUIModel -> R.layout.venue_info_website_item
                is VenueInfoSeparatorUIModel -> R.layout.venue_info_separator_item
                is VenueInfoHeader2UIModel -> R.layout.venue_info_header_2_item
                is VenueInfoDescriptionUIModel -> R.layout.venue_info_description_item
                else -> throw RuntimeException("Such UI model does not exist")
            }.exhaustive

}