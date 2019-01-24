package com.loyalty.customer.presentation.coordinator

import com.loyalty.core.presentation.coordinator.FlowActivity
import com.loyalty.customer.presentation.navigation.CustomerNavigationActivity
import org.koin.android.viewmodel.ext.android.viewModel

class CustomerFlowActivity : FlowActivity<CustomerFlowEvent>() {

    override val viewModel: CustomerFlowViewModel by viewModel()

    override fun triggerEvent(event: CustomerFlowEvent) {
        super.triggerEvent(event)
        /* todo use router inside of presenter to do this */
        if (event.isUserLoggedIn) {
            startActivity(CustomerNavigationActivity.newIntent(this, event.isUserLoggedIn))
        }
    }

}