package com.loyalty.customer.presentation.venue.adapter

import android.view.View
import com.loyalty.customer.ui.models.VenueInformationScheduleUIModel
import kotlinx.android.synthetic.main.venue_information_schedule_item.view.venueInformationScheduleDay
import kotlinx.android.synthetic.main.venue_information_schedule_item.view.venueInformationScheduleWorkingHours

class VenueInformationScheduleHolder(itemView: View) : VenueInformationHolder<VenueInformationScheduleUIModel>(itemView) {

    val day = itemView.venueInformationScheduleDay
    val workingHours = itemView.venueInformationScheduleWorkingHours

    override fun bind(model: VenueInformationScheduleUIModel) {
        day.text = model.day
        workingHours.text = model.hours
    }

}