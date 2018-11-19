package com.loyalty.customer.presentation.navigation

import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.view.BaseActivity
import com.loyalty.customer.R
import org.koin.android.viewmodel.ext.android.viewModel

class NavigationActivity : BaseActivity<BaseState, BaseEvent>() {

    override val layout: Int = R.layout.activity_navigation

    override val viewModel: NavigationViewModel by viewModel()



}