package com.loyalty.core.exceptions

class NoArgumentException @JvmOverloads constructor(
        message: String? = "No extra passed inside",
        throwable: Throwable? = null
) : RuntimeException(message, throwable)