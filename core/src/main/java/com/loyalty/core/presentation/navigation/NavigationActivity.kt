package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.base.view.BaseActivity
import com.loyalty.core.presentation.base.view.OnBackPressedListener
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router

abstract class NavigationActivity : BaseActivity() {

    abstract val navigationBar: BottomNavigationView

    /* *
     * A map of bottom navigation button ids to the tab navigation.
     * Tab navigationFragmentNames are used as keys during navigation.
     * */
    abstract val navigationContainers: List<NavigationContainer>

    abstract val initialFragmentKey: String

    @get:IdRes
    abstract val containerId: Int

    abstract fun createNavigationFragment(screenKey: String): NavigationFragment

    val router: Router by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

        if (savedInstanceState == null) {
            selectTab(initialFragmentKey)
        }
    }

    private fun initViews() {
        navigationBar.setOnNavigationItemSelectedListener { selectMenuItem(it) }
    }

    private fun selectMenuItem(item: MenuItem): Boolean {
        val fragmentKey = navigationContainers.find {
            it.navigationItemId == item.itemId
        }
        fragmentKey?.let {
            selectTab(it.navigationFragmentName)
        }
        item.isChecked = true
        return false
    }

    private fun selectTab(fragmentKey: String) {
        val currentFragment = supportFragmentManager.fragments.find { it.isVisible }
        var newFragment = supportFragmentManager.findFragmentByTag(fragmentKey)

        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return

        supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                newFragment = createNavigationFragment(fragmentKey)
            }
            replace(containerId, newFragment!!, fragmentKey)
            addToBackStack(null)
            commit()
        }
        supportFragmentManager.executePendingTransactions()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.fragments.find {
            it.isVisible
        }
        if ((fragment as? OnBackPressedListener)?.onBackPressed() == false) {
            router.exit()
        }
    }

    protected fun findNavigationMap(screenKey: String): NavigationContainer =
            navigationContainers.find {
                it.navigationFragmentName == screenKey
            } ?: throw NavigationException("Navigation container key doesn't exist")

}