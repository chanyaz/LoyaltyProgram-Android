package com.loyalty.customer.presentation.venues.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueUIModel

class VenueAdapter(private val elements: List<VenueUIModel>) : RecyclerView.Adapter<VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_item, parent, false)
        return VenueHolder(view)
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(holder: VenueHolder, position: Int) =
            holder.bind(elements[position])

}