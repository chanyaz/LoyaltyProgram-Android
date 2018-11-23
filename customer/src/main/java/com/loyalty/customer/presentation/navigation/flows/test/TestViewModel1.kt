package com.loyalty.customer.presentation.navigation.flows.test

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.BaseViewModel
import com.loyalty.customer.presentation.navigation.flows.CardsNavigationFragment.Companion.KEY_SECOND
import ru.terrakok.cicerone.Router

class TestViewModel1(
        private val router: Router
) : BaseViewModel<BaseState, BaseEvent>() {

    fun moveToTwo() {
        router.navigateTo(KEY_SECOND)
    }


}