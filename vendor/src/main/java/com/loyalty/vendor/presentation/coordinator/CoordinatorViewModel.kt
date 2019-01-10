package com.loyalty.vendor.presentation.coordinator

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError

class CoordinatorViewModel : BaseViewModel<BaseState, BaseEvent>() {

    init {
        selectUserFlow()
    }

    private fun selectUserFlow() {
        subscribe(tokenPreferences.isUserLoggedIn()
                .observeOnUi()
                .subscribeOrError("Unexpected error") { isUserLoggedIn ->
                    triggerEvent(CoordinatorEvent.CreateNavigation(isUserLoggedIn))
                }
        )
    }

}