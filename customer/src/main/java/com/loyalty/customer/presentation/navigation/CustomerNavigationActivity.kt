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

    override fun createNavigationFragment(screenKey: String): CustomerNavigationFragment =
            CustomerNavigationFragment.newInstance(findNavigationMap(screenKey))

    companion object {
        /* todo add separate menu for users which are not logged in */
        fun newIntent(context: Context): Intent =
                Intent(context, CustomerNavigationActivity::class.java)
    }

}