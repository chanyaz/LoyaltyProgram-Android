package com.loyalty.vendor.presentation.scan

import com.loyalty.core.presentation.base.BaseState

data class ScanState(
        val shouldInitialiseCamera: Boolean = false
) : BaseState()