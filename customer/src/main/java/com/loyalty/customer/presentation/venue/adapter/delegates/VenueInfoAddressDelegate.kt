package com.loyalty.customer.presentation.venue.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoAddressHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoAddressDelegate(val onVenueOptionClicked: (Int) -> Unit) : SimpleDelegate<VenueInfoAddressUIModel, VenueInfoUIModel, VenueInfoAddressHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoAddressHolder =
            VenueInfoAddressHolder(createView(parent, R.layout.venue_info_address_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoAddressUIModel

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as VenueInfoAddressHolder).itemView.setOnClickListener {
            onVenueOptionClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as VenueInfoAddressHolder).itemView.setOnClickListener(null)
    }

}