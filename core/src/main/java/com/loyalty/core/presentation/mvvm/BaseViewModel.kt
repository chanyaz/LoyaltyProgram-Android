package com.loyalty.core.presentation.mvvm

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import ru.terrakok.cicerone.Router

abstract class BaseViewModel<S, E> : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()
    protected var router: Router? = null

    private val stateSubject: BehaviorSubject<S> = BehaviorSubject.create()
    val stateObservable: Observable<S> = stateSubject

    private val eventSubject: PublishSubject<E> = PublishSubject.create()
    val eventObservable: Observable<E> = eventSubject

    fun initRouter(router: Router?) {
        this.router = router
    }

    override fun onCleared() {
        disposables.clear()
    }

    protected fun setState(newState: S) {
        stateSubject.onNext(newState)
    }

    protected fun triggerEvent(newEvent: E) {
        eventSubject.onNext(newEvent)
    }

}