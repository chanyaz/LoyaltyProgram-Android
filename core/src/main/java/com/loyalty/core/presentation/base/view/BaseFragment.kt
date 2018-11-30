package com.loyalty.core.presentation.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router

abstract class BaseFragment : Fragment(), OnBackPressedListener {

    @get:LayoutRes
    abstract val layout: Int

    protected val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

    val router: Router by lazy {
        (parentFragment as? NavigationFragment)?.cicerone?.router ?: throw NavigationException("Router should not be null")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleDisposable.clear()
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    protected fun subscribe(disposable: Disposable) {
        lifecycleDisposable += disposable
    }

}