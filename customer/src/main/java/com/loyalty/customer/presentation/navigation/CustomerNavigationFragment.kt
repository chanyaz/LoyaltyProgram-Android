package com.loyalty.customer.presentation.navigation

import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.core.presentation.navigation.NavigationContainer
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment1
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment2
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment3

class CustomerNavigationFragment : NavigationFragment() {

    override fun createFragment(screenKey: String, data: Any?): BaseFragment {
        return when (screenKey) {
            CustomerScreens.KEY_FIRST.name -> TestFragment1()
            CustomerScreens.KEY_SECOND.name -> TestFragment2()
            CustomerScreens.KEY_THIRD.name -> TestFragment3()
            else -> throw NavigationException("Fragment key doesn't exist")
        }
    }

    companion object {
        fun newInstance(navigationContainer: NavigationContainer): CustomerNavigationFragment =
                NavigationFragment.newInstance(navigationContainer, CustomerNavigationFragment())
    }

}

