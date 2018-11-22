package com.loyalty.core.presentation.view

import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.BaseViewModel
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

interface BaseView<S: BaseState, E: BaseEvent> {

    @get:LayoutRes
    val layout: Int
    val viewModel: BaseViewModel<S, E>

    val lifecycleDisposable: CompositeDisposable

    @CallSuper
    fun processState(baseState: BaseState) {
        Timber.d("Processing stateObservable: ${baseState.javaClass.simpleName}")
    }

    @CallSuper
    fun processEvent(baseEvent: BaseEvent) {
        Timber.d("Processing eventObservable: ${baseEvent.javaClass.simpleName}")
    }

}