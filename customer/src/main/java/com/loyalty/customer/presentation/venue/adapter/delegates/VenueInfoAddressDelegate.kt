package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoAddressHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoAddressDelegate : SimpleDelegate<VenueInfoAddressUIModel, VenueInfoUIModel, VenueInfoAddressHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoAddressHolder =
            VenueInfoAddressHolder(createView(parent, R.layout.venue_info_address_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoAddressUIModel

}