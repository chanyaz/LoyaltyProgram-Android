package com.loyalty.core.presentation.coordinator

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class FlowViewModel<E: FlowEvent> : BaseViewModel<BaseState, E>() {

    override val initialState: BaseState get() = object : BaseState() {}

    abstract fun selectUserFlow()

}