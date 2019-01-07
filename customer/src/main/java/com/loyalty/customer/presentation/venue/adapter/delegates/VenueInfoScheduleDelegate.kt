package com.loyalty.customer.presentation.venue.adapter.delegates

import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoScheduleHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoScheduleUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoScheduleDelegate : SimpleDelegate<VenueInfoScheduleUIModel, VenueInfoUIModel, VenueInfoScheduleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoScheduleHolder =
            VenueInfoScheduleHolder(createView(parent, R.layout.venue_info_schedule_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoScheduleUIModel

}