package com.loyalty.core.util

data class SingleEventFlag(
        private var initialValue: Boolean = false
) {

    var value: Boolean = initialValue
        private set
        get() {
            if (!initialValue)
                return false

            if (initialValue && field) {
                value = false
                initialValue = false
                return true
            } else {
                return false
            }
        }

}