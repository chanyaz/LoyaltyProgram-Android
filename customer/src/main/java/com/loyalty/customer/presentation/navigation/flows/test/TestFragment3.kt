package com.loyalty.customer.presentation.navigation.flows.test

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.test3_fragment.test3
import org.koin.android.ext.android.inject

class TestFragment3 : MvvmFragment<BaseState, BaseEvent>() {

    override val layout: Int = R.layout.test3_fragment

    override val viewModel: TestViewModel3 by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test3.setOnClickListener {

        }
    }

}