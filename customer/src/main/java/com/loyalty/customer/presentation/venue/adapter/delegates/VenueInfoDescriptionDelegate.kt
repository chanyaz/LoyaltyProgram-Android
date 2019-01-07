package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoDescriptionHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoDescriptionUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoDescriptionDelegate : SimpleDelegate<VenueInfoDescriptionUIModel, VenueInfoUIModel, VenueInfoDescriptionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoDescriptionHolder =
            VenueInfoDescriptionHolder(createView(parent, R.layout.venue_info_description_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoDescriptionUIModel

}