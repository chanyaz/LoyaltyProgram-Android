package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoSeparatorHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoSeparatorUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoSeparatorDelegate : SimpleDelegate<VenueInfoSeparatorUIModel, VenueInfoUIModel, VenueInfoSeparatorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoSeparatorHolder =
            VenueInfoSeparatorHolder(createView(parent, R.layout.venue_info_separator_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoSeparatorUIModel

}