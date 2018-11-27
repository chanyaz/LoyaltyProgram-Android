package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.base.view.ViewModelOwner

abstract class MvvmFragment<S: BaseState, E: BaseEvent> : BaseFragment(), ViewModelOwner<S, E> {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBaseViewModel(lifecycleDisposable)
    }

}