package com.loyalty.core.presentation

import android.support.annotation.LayoutRes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

interface BaseView<S: BaseState, E: BaseEvent, VM: BaseViewModel<S, E>> {

    @get:LayoutRes
    val layout: Int
    val viewModel: VM

    val lifecycleDisposable: CompositeDisposable

    fun processState(baseState: BaseState) {
        Timber.d("Processing state: ${baseState.javaClass.simpleName}")
    }
    fun processEvent(baseEvent: BaseEvent) {
        Timber.d("Processing event: ${baseEvent.javaClass.simpleName}")
    }

    fun observeViewModel() {
        observeEvents()
        observeState()
    }

    private fun observeEvents() {
        lifecycleDisposable.add(viewModel.event
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processEvent(it)
                })
    }

    private fun observeState() {
        lifecycleDisposable.add(viewModel.state
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processState(it)
                })
    }

}