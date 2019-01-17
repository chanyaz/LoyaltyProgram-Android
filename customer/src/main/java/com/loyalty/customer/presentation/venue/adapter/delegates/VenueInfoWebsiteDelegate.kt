package com.loyalty.customer.presentation.venue.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoWebsiteHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoWebsiteUIModel

class VenueInfoWebsiteDelegate(val onVenueOptionClicked: (Int) -> Unit) : SimpleDelegate<VenueInfoWebsiteUIModel, VenueInfoUIModel, VenueInfoWebsiteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoWebsiteHolder =
            VenueInfoWebsiteHolder(createView(parent, R.layout.venue_info_website_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoWebsiteUIModel

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as VenueInfoWebsiteHolder).itemView.setOnClickListener {
            onVenueOptionClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as VenueInfoWebsiteHolder).itemView.setOnClickListener(null)
    }

}