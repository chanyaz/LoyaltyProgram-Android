package com.loyalty.customer.presentation.venues.adapter.holders

import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleDelegationHolder
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import kotlinx.android.synthetic.main.venue_item.view.venueAddress
import kotlinx.android.synthetic.main.venue_item.view.venueImage
import kotlinx.android.synthetic.main.venue_item.view.venueLocationDistance
import kotlinx.android.synthetic.main.venue_item.view.venueLocationIcon
import kotlinx.android.synthetic.main.venue_item.view.venueName
import kotlinx.android.synthetic.main.venue_item.view.venueScheduleIcon
import kotlinx.android.synthetic.main.venue_item.view.venueWorkingHours

class VenueHolder(itemView: View) : SimpleDelegationHolder<VenueItemUIModel>(itemView) {

    private val venueName = itemView.venueName
    private val venueAddress = itemView.venueAddress
    private val venueLocationIcon = itemView.venueLocationIcon
    private val venueLocationDistance = itemView.venueLocationDistance
    private val venueScheduleIcon = itemView.venueScheduleIcon
    private val venueWorkingHours = itemView.venueWorkingHours
    private val venueImage = itemView.venueImage

    override fun bind(model: VenueItemUIModel) {
        with(model) {
            venueName.text = name
            venueAddress.text = address
            venueWorkingHours.text = workingHours
            Glide.with(itemView).load(imageUrl).into(venueImage)

            if (distance == null) {
                venueLocationDistance.invisible()
                venueLocationIcon.invisible()
            } else {
                venueLocationDistance.text = itemView.context.getString(R.string.venue_km_distance, distance)
                venueLocationDistance.visible()
                venueLocationIcon.visible()
            }
        }
    }
}