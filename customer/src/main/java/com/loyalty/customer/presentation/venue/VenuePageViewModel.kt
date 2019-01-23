package com.loyalty.customer.presentation.venue

import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class VenuePageViewModel : BaseViewModel<VenuePageState, VenuePageEvent>() {

    abstract fun mapLoaded()

    abstract fun venueOptionClicked(position: Int)

    abstract fun back()

    abstract fun hideToolbarTitles()

    abstract fun showToolbarTitles()

}