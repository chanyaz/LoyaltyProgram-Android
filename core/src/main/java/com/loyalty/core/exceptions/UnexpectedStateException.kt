package com.loyalty.core.exceptions

class UnexpectedStateException @JvmOverloads constructor(
        message: String? = null,
        throwable: Throwable? = null
) : RuntimeException(message, throwable)