package com.loyalty.customer.presentation.venue.adapter.options

import android.support.v4.content.ContextCompat
import android.view.View
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.ui.models.VenueOptionUIModel
import kotlinx.android.synthetic.main.venue_option_item.view.venueOption

class VenueOptionHolder(itemView: View) : SimpleHolder<VenueOptionUIModel>(itemView) {

    private val venueOption = itemView.venueOption

    override fun bind(model: VenueOptionUIModel) {
        venueOption.text = model.title
        venueOption.setCompoundDrawablesRelative(ContextCompat.getDrawable(itemView.context, model.iconRes), null, null, null)
    }

}