package com.loyalty.customer.presentation.venue

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class VenuePageViewModel : BaseViewModel<VenuePageState, BaseEvent>() {

    abstract fun initViewModel()

    abstract fun mapLoaded()

    abstract fun back()

}