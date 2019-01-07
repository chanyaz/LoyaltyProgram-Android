package com.loyalty.customer.presentation.venues.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venues.adapter.holders.VenueHolder
import com.loyalty.customer.ui.models.venue.VenueItemUIModel

class VenueDelegate(
        private val onVenueClicked: (Int) -> Unit
) : SimpleDelegate<VenueItemUIModel, VenueItemUIModel, VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): VenueHolder =
            VenueHolder(createView(parent, R.layout.venue_item))

    override fun isForViewType(item: VenueItemUIModel, items: MutableList<VenueItemUIModel>, position: Int): Boolean = true

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as VenueHolder).itemView.setOnClickListener{
            onVenueClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as VenueHolder).itemView.setOnClickListener(null)
    }

}