package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.venue.information.VenueInfoScheduleUIModel
import kotlinx.android.synthetic.main.venue_info_schedule_item.view.venueInfoScheduleDay
import kotlinx.android.synthetic.main.venue_info_schedule_item.view.venueInfoScheduleWorkingHours

class VenueInfoScheduleHolder(itemView: View) : VenueInfoHolder<VenueInfoScheduleUIModel>(itemView) {

    val day = itemView.venueInfoScheduleDay
    val workingHours = itemView.venueInfoScheduleWorkingHours

    override fun bind(model: VenueInfoScheduleUIModel) {
        day.text = model.day
        workingHours.text = model.hours
    }

}