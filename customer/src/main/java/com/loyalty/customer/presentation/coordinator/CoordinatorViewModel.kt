package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import com.loyalty.customer.preferences.token.TokenPreferences

class CoordinatorViewModel(
        private val tokenPreferences: TokenPreferences
) : BaseViewModel<BaseState, CoordinatorEvent>() {

    override val initialState: BaseState get() = object : BaseState() {}

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