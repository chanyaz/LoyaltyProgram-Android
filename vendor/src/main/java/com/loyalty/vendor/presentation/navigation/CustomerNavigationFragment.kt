package com.loyalty.customer.presentation.navigation

import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.core.presentation.navigation.NavigationContainer

class CustomerNavigationFragment : NavigationFragment() {

    override fun createFragment(screenKey: String, data: Any?): BaseFragment {
        throw NavigationException("No navigation yet lol")
//        return when (screenKey) {
//
//            else -> throw NavigationException("Fragment key doesn't exist")
//        }.exhaustive
    }

    companion object {
        fun newInstance(navigationContainer: NavigationContainer): CustomerNavigationFragment =
                NavigationFragment.newInstance(navigationContainer, CustomerNavigationFragment())
    }

}