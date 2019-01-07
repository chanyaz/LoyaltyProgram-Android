package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoHeader2Holder
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeader2UIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoHeader2Delegate : SimpleDelegate<VenueInfoHeader2UIModel, VenueInfoUIModel, VenueInfoHeader2Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoHeader2Holder =
            VenueInfoHeader2Holder(createView(parent, R.layout.venue_info_header_2_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoHeader2UIModel

}