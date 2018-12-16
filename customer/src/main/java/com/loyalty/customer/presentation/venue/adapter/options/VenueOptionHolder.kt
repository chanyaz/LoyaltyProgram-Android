package com.loyalty.customer.presentation.venue.adapter.options

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.loyalty.customer.ui.models.VenueOptionUIModel
import kotlinx.android.synthetic.main.venue_option_item.view.venueOption

class VenueOptionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val venueOption = itemView.venueOption

    fun bind(model: VenueOptionUIModel) {
        venueOption.text = model.title
        venueOption.setCompoundDrawablesRelative(ContextCompat.getDrawable(itemView.context, model.iconRes), null, null, null)
    }

}