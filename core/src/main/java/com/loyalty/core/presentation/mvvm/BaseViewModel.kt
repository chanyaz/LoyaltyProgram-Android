package com.loyalty.core.presentation.mvvm

import android.arch.lifecycle.ViewModel
import com.loyalty.core.presentation.navigation.router.Router
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

abstract class BaseViewModel<S, E> : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()
    protected lateinit var router: Router

    protected abstract val initialState: S
    internal fun requestInitialLayoutState(): S = stateSubject.value ?: throw RuntimeException("Current state is empty")

    private val stateSubject: BehaviorSubject<S> by lazy { BehaviorSubject.createDefault(initialState) }
    internal val stateObservable: Observable<S> get() = stateSubject

    protected val currentState: S get() = stateSubject.value ?: throw RuntimeException("Current state is empty")

    private val eventSubject: PublishSubject<E> = PublishSubject.create()
    internal val eventObservable: Observable<E> get() = eventSubject

    internal fun initRouter(router: Router) {
        this.router = router
    }

    override fun onCleared() {
        disposables.clear()
    }

    protected fun subscribe(disposable: Disposable) {
        disposables += disposable
    }

    protected fun setState(newState: S) {
        stateSubject.onNext(newState)
    }

    protected fun triggerEvent(newEvent: E) {
        eventSubject.onNext(newEvent)
    }

}