package com.loyalty.customer.presentation.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.loyalty.core.exceptions.NoArgumentException
import com.loyalty.core.presentation.navigation.NavigationActivity
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.navigation_activity.navigationCustomerBar

class CustomerNavigationActivity : NavigationActivity() {

    override val layout: Int get() = R.layout.navigation_activity

    override val navigationBar: BottomNavigationView get() = navigationCustomerBar

    override val navigationContainers: List<CustomerNavigationContainers> = CustomerNavigationContainers.values().toList()

    override val initialFragmentKey: String get() = CustomerNavigationContainers.Qr.navigationFragmentName

    override val containerId: Int get() = R.id.navigationCustomerContainer

    private val isUserLoggedIn: Boolean by lazy {
        intent?.extras?.getBoolean(KEY_IS_USER_LOGGED_IN) ?: throw NoArgumentException()
    }

    override fun createNavigationFragment(screenKey: String): CustomerNavigationFragment =
            CustomerNavigationFragment.newInstance(findNavigationMap(screenKey))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflateMenu()
    }

    private fun inflateMenu() {
        navigationBar.inflateMenu(if (isUserLoggedIn) R.menu.navigation_menu else R.menu.navigation_menu) // TODO is this needed?
    }

    companion object {
        private const val KEY_IS_USER_LOGGED_IN = "KEY_IS_USER_LOGGED_IN"

        fun newIntent(context: Context, isUserLoggedIn: Boolean): Intent =
                Intent(context, CustomerNavigationActivity::class.java).apply {
                    putExtra(KEY_IS_USER_LOGGED_IN, isUserLoggedIn)
                }
    }

}