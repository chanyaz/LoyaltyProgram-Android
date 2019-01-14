package com.loyalty.vendor.presentation.coordinator

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmActivity
import com.loyalty.vendor.R
import com.loyalty.vendor.presentation.navigation.VendorNavigationActivity
import org.koin.android.viewmodel.ext.android.viewModel

class CoordinatorActivity : MvvmActivity<CoordinatorState, BaseEvent>() {

    override val layout: Int get() = R.layout.coordinator_activity

    override val viewModel: CoordinatorViewModel by viewModel()

    override val router: Nothing get() = throw RuntimeException("Regular activity does not need router")

    override fun renderState(state: CoordinatorState) {
        super.renderState(state)
        startActivity(VendorNavigationActivity.newIntent(this, state.isUserLoggedIn))
    }
}