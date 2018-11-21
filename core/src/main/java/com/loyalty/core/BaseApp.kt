package com.loyalty.core

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.loyalty.core.logging.DebugTree
import com.loyalty.core.logging.ReleaseTree
import com.loyalty.core.di.ciceroneModule
import com.loyalty.core.util.delegates.ApplicationDelegate
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber

abstract class BaseApp: MultiDexApplication() {

    companion object {
        var application: Application by ApplicationDelegate()
    }

    private val cicerone: Cicerone<Router> = Cicerone.create()

    val navigationHolder: NavigatorHolder get() = cicerone.navigatorHolder
    val router: Router get() = cicerone.router

    private val coreModules: List<Module> = listOf(ciceroneModule)
    abstract val clientModules: List<Module>

    override fun onCreate() {
        super.onCreate()
        setupLogging()
        setupKoin()

        application = this
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) DebugTree() else ReleaseTree())
    }

    private fun setupKoin() {
        startKoin(this, coreModules + clientModules)
    }
}