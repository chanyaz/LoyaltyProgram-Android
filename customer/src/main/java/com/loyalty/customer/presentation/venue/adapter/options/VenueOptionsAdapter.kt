package com.loyalty.customer.presentation.venue.adapter.options

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.ui.models.VenueOptionUIModel

class VenueOptionsAdapter : SimpleAdapter<VenueOptionUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueOptionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_option_item, parent, false)
        return VenueOptionHolder(view)
    }

    override fun onViewAttachedToWindow(holder: SimpleHolder<VenueOptionUIModel>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener { view ->
            elements[holder.adapterPosition].intent?.let {
                holder.itemView.context.startActivity(it)
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: SimpleHolder<VenueOptionUIModel>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

}