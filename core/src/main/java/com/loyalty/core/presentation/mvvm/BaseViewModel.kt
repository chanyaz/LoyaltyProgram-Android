package com.loyalty.core.presentation.mvvm

import android.arch.lifecycle.ViewModel
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import ru.terrakok.cicerone.Router

abstract class BaseViewModel<S, E> : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()
    protected lateinit var router: Router

    private val stateSubject: BehaviorSubject<S> = BehaviorSubject.create()
    internal val stateObservable: Observable<S> = stateSubject

    protected val currentState: S get() = stateSubject.value ?: throw RuntimeException("Current state is empty")

    private val eventSubject: PublishSubject<E> = PublishSubject.create()
    internal val eventObservable: Observable<E> = eventSubject

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