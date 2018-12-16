package com.loyalty.customer.presentation.venues.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueItemUIModel

class VenuesAdapter(
        private var elements: List<VenueItemUIModel>,
        private val onVenueClicked: (Int) -> Unit
) : RecyclerView.Adapter<VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_item, parent, false)
        return VenueHolder(view)
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(holder: VenueHolder, position: Int) =
            holder.bind(elements[position])

    override fun onViewAttachedToWindow(holder: VenueHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            onVenueClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: VenueHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun setItems(items: List<VenueItemUIModel>) {
        elements = items
        notifyDataSetChanged() // todo use diff util
    }

}