package com.loyalty.customer.presentation.venue.adapter.images

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R

class VenueImagesAdapter(private val urls: List<String>) : RecyclerView.Adapter<VenueImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_image_item, parent, false)
        return VenueImageHolder(view)
    }

    override fun getItemCount(): Int = urls.size

    override fun onBindViewHolder(viewHolder: VenueImageHolder, position: Int) =
            viewHolder.bind(urls[position])

}