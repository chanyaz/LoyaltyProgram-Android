package com.loyalty.core.presentation

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

abstract class BaseViewModel<S, E> : ViewModel() {

    protected val disposables = CompositeDisposable()

    protected val stateSubject: BehaviorSubject<S> = BehaviorSubject.create()
    val state: Observable<S> = stateSubject

    protected val eventSubject: PublishSubject<E> = PublishSubject.create()
    val event: Observable<E> = eventSubject

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