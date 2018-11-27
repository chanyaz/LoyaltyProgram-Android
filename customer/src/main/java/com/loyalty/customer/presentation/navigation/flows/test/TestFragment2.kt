package com.loyalty.customer.presentation.navigation.flows.test

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.test2_fragment.test2
import org.koin.android.ext.android.inject

class TestFragment2 : MvvmFragment<BaseState, BaseEvent>() {

    override val layout: Int = R.layout.test2_fragment

    override val viewModel: TestViewModel2 by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test2.setOnClickListener {
            viewModel.moveToThree()
        }
    }

}