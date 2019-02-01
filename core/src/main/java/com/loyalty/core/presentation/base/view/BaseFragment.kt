package com.loyalty.core.presentation.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    abstract val layout: Int

    protected val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleDisposable.clear()
    }

    protected fun subscribe(disposable: Disposable) {
        lifecycleDisposable += disposable
    }

}