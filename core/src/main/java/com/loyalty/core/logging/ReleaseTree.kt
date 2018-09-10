package com.loyalty.core.logging

import android.util.Log

class ReleaseTree: BaseTree() {

    override val LOG_LENGTH: Int = 4_000

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return when (priority) {
            Log.VERBOSE, Log.DEBUG, Log.INFO -> false
            Log.WARN, Log.ERROR -> true
            else -> true
        }
    }

}