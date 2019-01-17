package com.loyalty.customer.presentation.venue.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.holders.VenueInfoPhoneHolder
import com.loyalty.customer.ui.models.venue.information.VenueInfoPhoneUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoPhoneDelegate(val onVenueOptionClicked: (Int) -> Unit) : SimpleDelegate<VenueInfoPhoneUIModel, VenueInfoUIModel, VenueInfoPhoneHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueInfoPhoneHolder =
            VenueInfoPhoneHolder(createView(parent, R.layout.venue_info_phone_item))

    override fun isForViewType(item: VenueInfoUIModel, items: MutableList<VenueInfoUIModel>, position: Int): Boolean =
            item is VenueInfoPhoneUIModel

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as VenueInfoPhoneHolder).itemView.setOnClickListener {
            onVenueOptionClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as VenueInfoPhoneHolder).itemView.setOnClickListener(null)
    }

}