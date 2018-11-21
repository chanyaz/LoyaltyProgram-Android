package com.loyalty.core.presentation.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<S: BaseState, E: BaseEvent>
    : Fragment(), BaseView<S, E> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    override fun processEvent(baseEvent: BaseEvent) {
        super.processEvent(baseEvent)
        /* todo handle some of the base events */
    }

}