package com.loyalty.core.presentation.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<S: BaseState, E: BaseEvent>
    : Fragment(), BaseView<S, E> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleDisposable += viewModel.eventObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    super.processEvent(it)
                    processEvent(it)
                }

        lifecycleDisposable += viewModel.stateObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    super.processState(it)
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

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleDisposable.clear()
    }

}