package com.loyalty.core.presentation.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.navigation.router.Router
import com.loyalty.core.presentation.navigation.router.RouterOwner
import com.loyalty.core.util.extensions.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseBottomSheet : BottomSheetDialogFragment(), OnBackPressedListener {

    @get:LayoutRes
    abstract val layout: Int

    val router: Router by lazy {
        (parentFragment as? RouterOwner)?.router ?: throw NavigationException("Router should not be null")
    }

    protected val lifecycleDisposable: CompositeDisposable = CompositeDisposable()

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