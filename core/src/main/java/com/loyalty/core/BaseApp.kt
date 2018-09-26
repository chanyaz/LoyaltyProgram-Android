package com.loyalty.core

import android.support.multidex.MultiDexApplication
import com.loyalty.core.logging.DebugTree
import com.loyalty.core.logging.ReleaseTree
import timber.log.Timber

class BaseApp: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        setupLogging()
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) DebugTree() else ReleaseTree())
    }
}