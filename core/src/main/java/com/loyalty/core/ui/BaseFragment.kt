package com.loyalty.core.ui

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.loyalty.core.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<VM : BaseViewModel>: Fragment() {

//    todo inject view model

    @get:LayoutRes
    protected abstract val layoutId: Int

    val disposables = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

//    todo add some helper methods like showing toast/snackbar, etc

}