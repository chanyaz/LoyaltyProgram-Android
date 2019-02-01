package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.coordinator.FlowViewModel
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import com.loyalty.customer.preferences.token.TokenPreferences

class CustomerFlowViewModel(
        private val tokenPreferences: TokenPreferences
) : FlowViewModel<CustomerFlowEvent>() {

    override fun selectUserFlow() {
        subscribe(tokenPreferences.isUserLoggedIn()
                .observeOnUi()
                .subscribeOrError("Unexpected error") { isUserLoggedIn ->
                    triggerEvent(CustomerFlowEvent(true))
                }
        )
    }

}