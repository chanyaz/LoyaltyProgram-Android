package com.loyalty.customer.presentation.navigation.flows

import android.os.Bundle
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment1
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment2
import com.loyalty.customer.presentation.navigation.flows.test.TestFragment3

class VenuesNavigationFragment : NavigationFragment() {

    override fun createFragment(screenKey: String, data: Any?): BaseFragment {
        return when (screenKey) {
            KEY_FIRST -> TestFragment1()
            KEY_SECOND -> TestFragment2()
            KEY_THIRD -> TestFragment3()
            else -> throw RuntimeException("Not yet implemented")
        }
    }

    companion object {
        const val KEY_FIRST = "KEY_FIRST"
        const val KEY_SECOND = "KEY_SECOND"
        const val KEY_THIRD = "KEY_THIRD"
        fun newInstance(containerName: String): VenuesNavigationFragment =
                VenuesNavigationFragment().apply {
                    arguments = Bundle().apply {
                        putString(KEY_EXTRA_CONTAINER_NAME, containerName)
                        putString(KEY_EXTRA_INITIAL_FRAGMENT, KEY_FIRST)
                    }
                }
    }

}