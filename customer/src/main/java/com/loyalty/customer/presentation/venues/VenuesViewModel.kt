package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class VenuesViewModel : BaseViewModel<VenuesState, BaseEvent>() {

    abstract fun initViewModel()

    abstract fun filterVenues(searchQuery: String)

    abstract fun selectVenue(position: Int)

    abstract fun openSearch()

    abstract fun closeSearch()

}