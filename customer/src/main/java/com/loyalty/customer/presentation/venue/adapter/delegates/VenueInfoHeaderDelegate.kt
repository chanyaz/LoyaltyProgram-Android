package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoHeaderHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeaderUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoHeaderDelegate : SimpleDelegate<VenueInfoHeaderUIModel, VenueInfoUIModel, VenueInfoHeaderHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoHeaderHolder =
            VenueInfoHeaderHolder(createView(parent, R.layout.venue_info_header_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoHeaderUIModel

}