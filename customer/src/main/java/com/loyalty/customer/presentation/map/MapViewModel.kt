package com.loyalty.customer.presentation.map

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class MapViewModel : BaseViewModel<MapState, BaseEvent>() {

    abstract fun mapLoaded()

}
