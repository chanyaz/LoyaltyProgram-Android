package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.loyalty.core.presentation.base.view.BaseActivity

abstract class NavigationActivity : BaseActivity() {

    abstract val navigationBar: BottomNavigationView

    /* *
     * A map of bottom navigation button ids to the tab names.
     * Tab names are used as keys during navigation.
     * */
    abstract val idToKeyMap: Map<Int, String>

    abstract val initialFragmentKey: String

    @get:IdRes
    abstract val containerId: Int

    abstract fun createNavigationFragment(screenKey: String): NavigationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationView()

        selectTab(initialFragmentKey)
    }

    private fun initNavigationView() {
        navigationBar.setOnNavigationItemSelectedListener {
            selectMenuItem(it)
        }
    }

    private fun selectMenuItem(item: MenuItem): Boolean {
        val fragmentKey = idToKeyMap[item.itemId]
        fragmentKey?.let {
            selectTab(fragmentKey)
        }
        return false
    }

    private fun selectTab(fragmentKey: String) {
        val currentFragment = supportFragmentManager.fragments.find { it.isVisible }
        val newFragment = supportFragmentManager.findFragmentByTag(fragmentKey)

        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return

        supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                add(containerId, createNavigationFragment(fragmentKey), fragmentKey)
            }
            currentFragment?.let { hide(currentFragment) }
            newFragment?.let { show(newFragment) }
            commitNow()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return selectMenuItem(item)
    }

}