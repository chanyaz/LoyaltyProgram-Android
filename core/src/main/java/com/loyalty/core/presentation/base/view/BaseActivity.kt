package com.loyalty.core.presentation.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : AppCompatActivity() {

    @get:LayoutRes
    abstract val layout: Int

    protected val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleDisposable.clear()
    }

    protected fun subscribe(disposable: Disposable) {
        lifecycleDisposable += disposable
    }

}