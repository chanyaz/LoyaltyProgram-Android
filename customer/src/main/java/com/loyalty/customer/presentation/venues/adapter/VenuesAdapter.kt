package com.loyalty.customer.presentation.venues.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueItemUIModel

class VenuesAdapter(
        private val onVenueClicked: (Int) -> Unit
) : SimpleAdapter<VenueItemUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_item, parent, false)
        return VenueHolder(view)
    }

    override fun onViewAttachedToWindow(holder: SimpleHolder<VenueItemUIModel>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            onVenueClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: SimpleHolder<VenueItemUIModel>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

}