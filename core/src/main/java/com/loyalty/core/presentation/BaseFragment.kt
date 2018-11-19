package com.loyalty.core.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<S: BaseState, E: BaseEvent, VM: BaseViewModel<S, E>>: Fragment(), BaseView<S, E, VM> {

    override val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}