package com.loyalty.customer.presentation.qr

import android.graphics.Bitmap
import com.loyalty.core.presentation.base.BaseState

data class QrState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val qrBitmap: Bitmap? = null
) : BaseState()