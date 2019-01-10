package com.loyalty.vendor.presentation.navigation

import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.core.presentation.navigation.NavigationContainer
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.vendor.presentation.scan.ScanFragment

class VendorNavigationFragment : NavigationFragment() {

    override fun createFragment(screenKey: String, data: Any?): BaseFragment {
        return when (screenKey) {
            VendorScreens.KEY_SCAN.name -> ScanFragment.newInstance()
            else -> throw NavigationException("Fragment key doesn't exist")
        }.exhaustive
    }

    companion object {
        fun newInstance(navigationContainer: NavigationContainer): VendorNavigationFragment =
                NavigationFragment.newInstance(navigationContainer, VendorNavigationFragment())
    }

}