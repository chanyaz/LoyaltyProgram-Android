package com.loyalty.core

import android.app.Application
import com.loyalty.core.logging.DebugTree
import com.loyalty.core.logging.ReleaseTree
import timber.log.Timber

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setupLogging()
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) DebugTree() else ReleaseTree())
    }
}