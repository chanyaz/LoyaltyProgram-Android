package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import com.loyalty.customer.preferences.CustomerPreferences

class CoordinatorViewModel(
        private val customerPreferences: CustomerPreferences
) : BaseViewModel<BaseState, CoordinatorEvent>() {

    init {
        selectUserFlow()
    }

    private fun selectUserFlow() {
        subscribe(customerPreferences.isUserLoggedIn()
                .observeOnUi()
                .subscribeOrError("Unexpected error") { isUserLoggedIn ->
                    triggerEvent(CoordinatorEvent.CreateNavigation(isUserLoggedIn))
                }
        )
    }

}