package com.loyalty.vendor.presentation.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.loyalty.core.exceptions.NoArgumentException
import com.loyalty.core.presentation.navigation.NavigationActivity
import com.loyalty.vendor.R
import kotlinx.android.synthetic.main.navigation_activity.navigationVendorBar

class VendorNavigationActivity : NavigationActivity() {

    override val layout: Int get() = R.layout.navigation_activity

    override val navigationBar: BottomNavigationView get() = navigationVendorBar

    override val navigationContainers: List<VendorNavigationContainers> = VendorNavigationContainers.values().toList()

    override val initialFragmentKey: String get() = VendorNavigationContainers.SCAN.navigationFragmentName

    override val containerId: Int get() = R.id.navigationVendorContainer

    private val isUserLoggedIn: Boolean by lazy {
        intent?.extras?.getBoolean(KEY_IS_USER_LOGGED_IN) ?: throw NoArgumentException()
    }

    override fun createNavigationFragment(screenKey: String): VendorNavigationFragment =
            VendorNavigationFragment.newInstance(findNavigationMap(screenKey))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflateMenu()
    }

    private fun inflateMenu() {
        navigationBar.inflateMenu(R.menu.navigation_menu)
    }

    companion object {
        private const val KEY_IS_USER_LOGGED_IN = "KEY_IS_USER_LOGGED_IN"

        fun newIntent(context: Context, isUserLoggedIn: Boolean): Intent =
                Intent(context, VendorNavigationActivity::class.java).apply {
                    putExtra(KEY_IS_USER_LOGGED_IN, isUserLoggedIn)
                }
    }

}