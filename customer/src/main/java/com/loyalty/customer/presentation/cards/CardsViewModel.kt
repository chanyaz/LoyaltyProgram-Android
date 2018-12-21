package com.loyalty.customer.presentation.cards

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class CardsViewModel: BaseViewModel<CardsState, BaseEvent>() {

    abstract fun selectCard(position: Int)

}