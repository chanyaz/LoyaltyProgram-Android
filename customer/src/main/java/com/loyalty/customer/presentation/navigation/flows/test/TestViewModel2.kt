package com.loyalty.customer.presentation.navigation.flows.test

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel

class TestViewModel2() : BaseViewModel<BaseState, BaseEvent>() {

    fun moveToThree() {
        router.navigateTo("KEY_THIRD")
    }

}