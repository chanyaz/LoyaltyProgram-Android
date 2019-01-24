package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.base.view.OnBackPressedListener
import com.loyalty.core.presentation.base.view.ViewModelOwner
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.core.presentation.navigation.router.Router
import com.loyalty.core.presentation.navigation.router.RouterOwner
import com.tbruyelle.rxpermissions2.RxPermissions

abstract class MvvmFragment<S: BaseState, E: BaseEvent> : BaseFragment(), ViewModelOwner<S, E>, RouterOwner, OnBackPressedListener {

    override val router: Router by lazy {
        (parentFragment as? NavigationFragment)?.cicerone?.router ?: throw NavigationException("Router should not be null")
    }

    /* *
     * In case of any issues take a look at
     * @see <a href="https://gist.github.com/SpKiwi/c440f938b24abcc96bfe6e44b28109d2">A certain way to check if the fragment is visible</a>
     * */

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel(lifecycleDisposable, router)

        renderState(viewModel.requestInitialLayoutState())
    }

    protected fun executeWithPermission(permission: String, onPermissionGranted: () -> Unit, onPermissionDenied: () -> Unit = {}) {
        subscribe(RxPermissions(this)
                .request(permission)
                .take(1)
                .subscribe { isPermissionGranted ->
                    if (isPermissionGranted) onPermissionGranted() else onPermissionDenied()
                }
        )
    }

    protected fun executeIfPermissionGranted(permission: String, onPermissionGranted: () -> Unit, onPermissionDenied: () -> Unit = {}) {
        if (isPermissionGranted(permission)) {
            onPermissionGranted()
        } else {
            onPermissionDenied()
        }
    }

    protected fun isPermissionGranted(permission: String): Boolean =
            RxPermissions(this).isGranted(permission)

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}