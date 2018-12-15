package com.loyalty.customer.presentation.venues.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueItemUIModel

class VenuesAdapter(
        private val elements: List<VenueItemUIModel>
) : RecyclerView.Adapter<VenueHolder>(), Filterable {

    private var filteredElements: List<VenueItemUIModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_item, parent, false)
        return VenueHolder(view)
    }

    override fun getItemCount(): Int = filteredElements.size

    override fun onBindViewHolder(holder: VenueHolder, position: Int) =
            holder.bind(filteredElements[position])

    override fun getFilter(): Filter = filter

    private val filter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val query = constraint.toString()
            filteredElements = if (query.isEmpty()) {
                elements
            } else {
                elements.filter {
                    it.name.contains(query, true) || it.address.contains(query, true)
                }
            }

            return FilterResults().apply { values = filteredElements }
        }

        @Suppress("UNCHECKED_CAST")
        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            filteredElements = results.values as List<VenueItemUIModel>
            notifyDataSetChanged()
        }
    }

}