package com.loyalty.core.presentation.coordinator

import android.os.Bundle
import com.loyalty.core.R
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmActivity

abstract class FlowActivity<E: FlowEvent> : MvvmActivity<BaseState, E>() {

    override val layout: Int get() = R.layout.coordinator_activity

    abstract override val viewModel: FlowViewModel<E>

    override val router: Nothing get() = throw RuntimeException("Regular activity does not need router")

    /* *
     * this check is implemented to address the following issue
     * https://stackoverflow.com/questions/19545889/app-restarts-rather-than-resumes
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot) {
            finish()
            return
        } else {
            viewModel.selectUserFlow()
        }
    }

}