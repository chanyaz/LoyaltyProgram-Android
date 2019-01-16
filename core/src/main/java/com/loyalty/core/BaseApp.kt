package com.loyalty.core

import android.support.multidex.MultiDexApplication
import com.loyalty.core.logging.DebugTree
import com.loyalty.core.logging.ReleaseTree
import com.loyalty.core.di.ciceroneModule
import com.loyalty.core.di.schedulerModule
import com.loyalty.core.presentation.navigation.router.Router
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import ru.terrakok.cicerone.Cicerone
import timber.log.Timber

abstract class BaseApp: MultiDexApplication() {

    private val cicerone: Cicerone<Router> = Cicerone.create(Router())

    val router: Router get() = cicerone.router

    private val coreModules: List<Module> = listOf(ciceroneModule, schedulerModule)

    abstract val clientModules: List<Module>

    override fun onCreate() {
        super.onCreate()
        setupLogging()
        setupKoin()
    }

    private fun setupLogging() {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree()) /* todo check what's wrong with projects debug tree */
    }

    private fun setupKoin() {
        startKoin(this, coreModules + clientModules)
    }
}