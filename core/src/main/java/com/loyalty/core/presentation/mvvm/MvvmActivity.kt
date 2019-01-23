package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.support.annotation.CallSuper
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseActivity
import com.loyalty.core.presentation.base.view.ViewModelOwner

abstract class MvvmActivity<S: BaseState, E: BaseEvent> : BaseActivity(), ViewModelOwner<S, E> {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToViewModel(lifecycleDisposable, false)
        renderState(viewModel.requestInitialLayoutState())
    }

}