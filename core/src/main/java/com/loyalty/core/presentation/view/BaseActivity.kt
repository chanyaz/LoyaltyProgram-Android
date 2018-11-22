package com.loyalty.core.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<S: BaseState, E: BaseEvent>
    : AppCompatActivity(), BaseView<S, E> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)

        lifecycleDisposable += viewModel.eventObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processEvent(it)
                }

        lifecycleDisposable += viewModel.stateObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    processState(it)
                }
    }

    /* Some of the base states can be added here */
    override fun processState(baseState: BaseState) {
        super.processState(baseState)
    }

    /* Some of the base events can be added here */
    override fun processEvent(baseEvent: BaseEvent) {
        super.processEvent(baseEvent)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleDisposable.clear()
    }

}