package com.loyalty.customer.presentation.navigation.flows.test

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel

class TestViewModel1() : BaseViewModel<BaseState, BaseEvent>() {

    fun moveToTwo() {
        router.navigateTo("KEY_SECOND")
    }


}