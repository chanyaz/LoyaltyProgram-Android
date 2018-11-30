package com.loyalty.core.exceptions

class NavigationException @JvmOverloads constructor(
        message: String? = null,
        throwable: Throwable? = null
) : RuntimeException(message, throwable)