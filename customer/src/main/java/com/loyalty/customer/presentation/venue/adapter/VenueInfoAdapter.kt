package com.loyalty.customer.presentation.venue.adapter

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.loyalty.core.ui.adapter.SimpleDelegationAdapter
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoAddressDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoDescriptionDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoHeader2Delegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoHeaderDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoPhoneDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoScheduleDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoSeparatorDelegate
import com.loyalty.customer.presentation.venue.adapter.delegates.VenueInfoWebsiteDelegate
import com.loyalty.customer.ui.models.venue.information.VenueInfoUIModel

class VenueInfoAdapter : SimpleDelegationAdapter<VenueInfoUIModel>(
        AdapterDelegatesManager<List<VenueInfoUIModel>>().apply {
            addDelegate(VenueInfoHeaderDelegate())
            addDelegate(VenueInfoAddressDelegate())
            addDelegate(VenueInfoSeparatorDelegate())
            addDelegate(VenueInfoScheduleDelegate())
            addDelegate(VenueInfoPhoneDelegate())
            addDelegate(VenueInfoWebsiteDelegate())
            addDelegate(VenueInfoHeader2Delegate())
            addDelegate(VenueInfoDescriptionDelegate())
        }
)