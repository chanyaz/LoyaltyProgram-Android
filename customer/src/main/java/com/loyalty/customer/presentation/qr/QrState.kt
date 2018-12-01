package com.loyalty.customer.presentation.qr

import android.graphics.Bitmap
import com.loyalty.core.presentation.base.BaseState

sealed class QrState : BaseState() {
    object QrLoading : QrState()
    object QrError : QrState()
    data class QrLoaded(val bitmap: Bitmap) : QrState()
}