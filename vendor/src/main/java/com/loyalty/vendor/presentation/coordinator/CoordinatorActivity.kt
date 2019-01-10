package com.loyalty.vendor.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmActivity
import com.loyalty.core.util.extensions.exhaustive
import org.koin.android.viewmodel.ext.android.viewModel

class CoordinatorActivity : MvvmActivity<BaseState, CoordinatorEvent>() {

    override val layout: Int get() = R.layout.coordinator_activity

    override val viewModel: CoordinatorViewModel by viewModel()

    override val router: Nothing get() = throw RuntimeException("Regular activity does not need router")

    override fun processEvent(event: CoordinatorEvent) {
        super.processEvent(event)
        when (event) {
            is CoordinatorEvent.CreateNavigation ->
                startActivity(CustomerNavigationActivity.newIntent(this, event.isUserLoggedIn))
        }.exhaustive
    }

}