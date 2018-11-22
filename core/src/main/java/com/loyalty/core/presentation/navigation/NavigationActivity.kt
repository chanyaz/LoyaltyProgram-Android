package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.loyalty.core.BaseApp
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.view.BaseActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.commands.Replace

abstract class NavigationActivity<S: BaseState, E: BaseEvent>
    : BaseActivity<S, E>() {

    abstract val navigationBar: BottomNavigationView

    abstract val idToKeyMap: Map<Int, String>

    abstract val initialFragmentKey: String

    @get:IdRes
    abstract val containerId: Int

    abstract fun createNavigationFragment(screenKey: String): NavigationFragment

    protected open val navigator: Navigator by lazy {
        object : SupportFragmentNavigator(supportFragmentManager, containerId) {
            override fun createFragment(screenKey: String, data: Any?): Fragment = createNavigationFragment(screenKey)
            override fun exit() = finish()
            override fun showSystemMessage(message: String?) = Unit
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationView()

        navigator.applyCommand(Replace(initialFragmentKey, null))
    }

    private fun initNavigationView() {
        navigationBar.setOnNavigationItemSelectedListener {
            selectMenuItem(it)
        }
    }

    private fun selectMenuItem(item: MenuItem): Boolean {
        val fragmentKey = idToKeyMap[item.itemId]
        fragmentKey?.let {
            navigator.applyCommand(Replace(it, null))
        }
        return false
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        (application as? BaseApp)?.navigationHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        (application as? BaseApp)?.navigationHolder?.removeNavigator()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return selectMenuItem(item)
    }

}