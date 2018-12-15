package com.loyalty.customer.presentation.qr

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.BaseViewModel

abstract class QrViewModel: BaseViewModel<QrState, BaseEvent>() {

    abstract fun initViewModel(qrWidth: Int, qrHeight: Int)

}