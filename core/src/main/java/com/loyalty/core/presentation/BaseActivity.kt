package com.loyalty.core.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

abstract class BaseActivity<S: BaseState, E: BaseEvent, VM: BaseViewModel<S, E>> : AppCompatActivity(), BaseView<S, E, VM> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Activity loaded: ${this.javaClass.simpleName}")
        setContentView(layout)

        observeViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("Activity destroyed: ${this.javaClass.simpleName}")

        lifecycleDisposable.clear()
    }

    override fun processEvent(baseEvent: BaseEvent) {
        super.processEvent(baseEvent)
        /* todo handle some of the base events */
    }

}