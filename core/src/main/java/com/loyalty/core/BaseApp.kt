package com.loyalty.core

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.loyalty.core.logging.DebugTree
import com.loyalty.core.logging.ReleaseTree
import com.loyalty.core.util.delegates.ApplicationDelegate
import timber.log.Timber

abstract class BaseApp: MultiDexApplication() {

    companion object {
        var application: Application by ApplicationDelegate()
    }

    override fun onCreate() {
        super.onCreate()
        setupLogging()

        application = this
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) DebugTree() else ReleaseTree())
    }
}