package com.loyalty.customer.presentation.navigation.flows.test

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.test1_fragment.test1
import org.koin.android.ext.android.inject

class TestFragment1 : MvvmFragment<BaseState, BaseEvent>() {

    override val layout: Int = R.layout.test1_fragment

    override val viewModel: TestViewModel1 by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test1.setOnClickListener {

        }
    }
}