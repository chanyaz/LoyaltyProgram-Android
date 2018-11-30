package com.loyalty.core.exceptions

class KeyAlreadyExistsException @JvmOverloads constructor(
        message: String? = "No extra passed inside",
        throwable: Throwable? = null
) : RuntimeException(message, throwable)