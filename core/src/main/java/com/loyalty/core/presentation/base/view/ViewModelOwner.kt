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

    fun subscribeToViewModel(compositeDisposable: CompositeDisposable, router: Router?) {
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

        router?.let {
            viewModel.initRouter(it)
        }
    }

    @CallSuper
    fun renderState(state: S) {
        Timber.d("Rendering state: $state")
    }

    @CallSuper
    fun triggerEvent(event: E) {
        Timber.d("Triggering event: $event")
    }

}