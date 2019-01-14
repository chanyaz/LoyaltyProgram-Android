package com.loyalty.vendor.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.core.util.extensions.subscribeOrError
import io.reactivex.Single

class CoordinatorViewModelImpl : CoordinatorViewModel() {

    override val initialState: BaseState get() = object : BaseState() {}

    init {
        selectUserFlow()
    }

    private fun selectUserFlow() {
        subscribe(Single.just(true)
                .observeOnUi()
                .subscribeOrError("Unexpected error") { isUserLoggedIn ->
                    triggerEvent(CoordinatorEvent.CreateNavigation(isUserLoggedIn))
                }
        )
    }

}