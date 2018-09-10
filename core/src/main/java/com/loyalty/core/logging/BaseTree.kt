package com.loyalty.core.logging

import android.util.Log
import timber.log.Timber

abstract class BaseTree: Timber.Tree() {

    abstract val LOG_LENGTH: Int

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (message.length < LOG_LENGTH) {
            if (priority == Log.ASSERT) {
                Log.wtf(tag, message)
            } else {
                Log.println(priority, tag, message)
            }
            return
        }

        var i = 0
        val length = message.length
        while (i < length) {
            var newline = message.indexOf('\n', i)
            newline = if (newline != -1) newline else length
            do {
                val end = Math.min(newline, i + LOG_LENGTH)
                val part = message.substring(i, end)
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, part)
                } else {
                    Log.println(priority, tag, part)
                }
                i = end
            } while (i < newline)
            i++
        }
    }

}