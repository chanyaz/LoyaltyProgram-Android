package com.loyalty.customer.presentation.venues.adapter.holders

import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleDelegationHolder
import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import kotlinx.android.synthetic.main.venue_item.view.venueAddress
import kotlinx.android.synthetic.main.venue_item.view.venueImage
import kotlinx.android.synthetic.main.venue_item.view.venueName
import kotlinx.android.synthetic.main.venue_item.view.venueWorkingHours

class VenueHolder(itemView: View) : SimpleDelegationHolder<VenueItemUIModel>(itemView) {

    private val venueName = itemView.venueName
    private val venueAddress = itemView.venueAddress
    private val venueWorkingHours = itemView.venueWorkingHours
    private val venueImage = itemView.venueImage

    override fun bind(model: VenueItemUIModel) {
        with(model) {
            venueName.text = name
            venueAddress.text = address
            venueWorkingHours.text = workingHours
            Glide.with(itemView).load(imageUrl).into(venueImage)
        }
    }
}