package com.loyalty.core.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<S: BaseState, E: BaseEvent, VM: BaseViewModel<S, E>>
    : AppCompatActivity(), BaseView<S, E, VM> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        observeViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleDisposable.clear()
    }

    override fun processEvent(baseEvent: BaseEvent) {
        super.processEvent(baseEvent)
        /* todo handle some of the base events */
    }

}