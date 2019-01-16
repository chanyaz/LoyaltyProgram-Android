package com.loyalty.core.presentation.mvvm

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.base.view.ViewModelOwner
import com.tbruyelle.rxpermissions2.RxPermissions

abstract class MvvmFragment<S: BaseState, E: BaseEvent> : BaseFragment(), ViewModelOwner<S, E> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { /* todo add request state function */
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel(lifecycleDisposable)
        renderState(viewModel.requestState())
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

}