package com.loyalty.customer.presentation.navigation.flows.test

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.BaseViewModel
import com.loyalty.customer.presentation.navigation.flows.CardsNavigationFragment.Companion.KEY_THIRD
import ru.terrakok.cicerone.Router

class TestViewModel2(
        private val router: Router
) : BaseViewModel<BaseState, BaseEvent>() {

    fun moveToThree() {
        router.navigateTo(KEY_THIRD)
    }

}