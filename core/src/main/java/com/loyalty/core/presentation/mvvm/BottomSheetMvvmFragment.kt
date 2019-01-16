package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseBottomSheet
import com.loyalty.core.presentation.base.view.ViewModelOwner
import com.loyalty.core.presentation.navigation.router.Router
import com.tbruyelle.rxpermissions2.RxPermissions

abstract class BottomSheetMvvmFragment<S: BaseState, E: BaseEvent> : BaseBottomSheet(), ViewModelOwner<S, E> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel(lifecycleDisposable)
        renderState(viewModel.requestState())
    }

}