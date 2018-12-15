package com.loyalty.customer.presentation.venues

import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class VenuesViewModel: BaseViewModel<VenuesState, VenuesEvent>() {

    abstract fun initViewModel()

    abstract fun filterVenues(query: String)

}