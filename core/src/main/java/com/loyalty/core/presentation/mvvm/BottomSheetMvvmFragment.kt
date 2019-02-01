package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseBottomSheet
import com.loyalty.core.presentation.base.view.ViewModelOwner

abstract class BottomSheetMvvmFragment<S: BaseState, E: BaseEvent> : BaseBottomSheet(), ViewModelOwner<S, E> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel(lifecycleDisposable, null)
        renderState(viewModel.requestInitialLayoutState())
    }

}