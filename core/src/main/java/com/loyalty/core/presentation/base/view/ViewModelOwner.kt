package com.loyalty.core.presentation.base.view

import android.support.annotation.CallSuper
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import timber.log.Timber

interface ViewModelOwner<S: BaseState, E: BaseEvent> {

    val viewModel: BaseViewModel<S, E>
    val router: Router

    fun subscribeToViewModel(compositeDisposable: CompositeDisposable, shouldInitRouter: Boolean = true) {
        compositeDisposable += viewModel.stateObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processState(it)
                }

        compositeDisposable += viewModel.eventObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processEvent(it)
                }

        if (shouldInitRouter)
            viewModel.initRouter(router)
    }

    @CallSuper
    fun processState(state: S) {
        Timber.d("Processing stateObservable: ${state.javaClass.simpleName}")
    }

    @CallSuper
    fun processEvent(event: E) {
        Timber.d("Processing eventObservable: ${event.javaClass.simpleName}")
    }

}