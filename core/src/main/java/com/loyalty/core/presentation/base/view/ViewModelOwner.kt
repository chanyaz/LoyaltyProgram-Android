package com.loyalty.core.presentation.base.view

import android.support.annotation.CallSuper
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.presentation.navigation.router.Router
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

interface ViewModelOwner<S: BaseState, E: BaseEvent> {

    val viewModel: BaseViewModel<S, E>
    val router: Router

    fun subscribeToViewModel(compositeDisposable: CompositeDisposable, shouldInitRouter: Boolean = true) {
        compositeDisposable += viewModel.stateObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    renderState(it)
                }

        compositeDisposable += viewModel.eventObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    triggerEvent(it)
                }

        if (shouldInitRouter)
            viewModel.initRouter(router)
    }

    @CallSuper
    fun renderState(state: S) {
        Timber.d("Rendering stateObservable: ${state.javaClass.simpleName}")
    }

    @CallSuper
    fun triggerEvent(event: E) {
        Timber.d("Triggering eventObservable: ${event.javaClass.simpleName}")
    }

}