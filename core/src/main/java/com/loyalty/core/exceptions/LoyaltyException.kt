package com.loyalty.core.exceptions

open class LoyaltyException @JvmOverloads constructor(message: String? = null, throwable: Throwable? = null): RuntimeException(message, throwable)