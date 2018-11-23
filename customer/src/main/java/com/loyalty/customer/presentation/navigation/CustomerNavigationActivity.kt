package com.loyalty.customer.presentation.navigation

import android.support.design.widget.BottomNavigationView
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.navigation.NavigationActivity
import com.loyalty.core.presentation.navigation.NavigationFragment
import com.loyalty.customer.R
import com.loyalty.customer.presentation.navigation.flows.CardsNavigationFragment
import com.loyalty.customer.presentation.navigation.flows.MapNavigationFragment
import com.loyalty.customer.presentation.navigation.flows.ProfileNavigationFragment
import com.loyalty.customer.presentation.navigation.flows.QrNavigationFragment
import com.loyalty.customer.presentation.navigation.flows.VenuesNavigationFragment
import kotlinx.android.synthetic.main.navigation_activity.navigationCustomerBar

class CustomerNavigationActivity : NavigationActivity() {

    override val layout: Int get() = R.layout.navigation_activity

    override val navigationBar: BottomNavigationView get() = navigationCustomerBar
    override val idToKeyMap: Map<Int, String> = mapOf(
            R.id.buttonNavigationQr to KEY_NAVIGATION_QR,
            R.id.buttonNavigationVenues to KEY_NAVIGATION_VENUES,
            R.id.buttonNavigationCards to KEY_NAVIGATION_CARDS,
            R.id.buttonNavigationMap to KEY_NAVIGATION_MAP,
            R.id.buttonNavigationProfile to KEY_NAVIGATION_PROFILE
    )
    override val initialFragmentKey: String get() = KEY_NAVIGATION_QR
    override val containerId: Int get() = R.id.navigationCustomerContainer

    override fun createNavigationFragment(screenKey: String): NavigationFragment {
        return when (screenKey) {
            KEY_NAVIGATION_QR -> NavigationFragment.newInstance(KEY_NAVIGATION_QR, "KEY_FIRST", QrNavigationFragment())
            KEY_NAVIGATION_VENUES -> NavigationFragment.newInstance(KEY_NAVIGATION_VENUES, "KEY_FIRST", VenuesNavigationFragment())
            KEY_NAVIGATION_CARDS -> NavigationFragment.newInstance(KEY_NAVIGATION_CARDS, "KEY_FIRST", CardsNavigationFragment())
            KEY_NAVIGATION_MAP -> NavigationFragment.newInstance(KEY_NAVIGATION_MAP, "KEY_FIRST", MapNavigationFragment())
            KEY_NAVIGATION_PROFILE -> NavigationFragment.newInstance(KEY_NAVIGATION_PROFILE, "KEY_FIRST", ProfileNavigationFragment())
            else -> throw NavigationException("Navigation container key doesn't exist")
        }

//        return when (screenKey) {
//            KEY_NAVIGATION_QR -> NavigationFragment.newInstance(KEY_NAVIGATION_QR, "KEY_FIRST", QrNavigationFragment())
//            KEY_NAVIGATION_VENUES -> VenuesNavigationFragment.newInstance(KEY_NAVIGATION_VENUES)
//            KEY_NAVIGATION_CARDS -> CardsNavigationFragment.newInstance(KEY_NAVIGATION_CARDS)
//            KEY_NAVIGATION_MAP -> MapNavigationFragment.newInstance(KEY_NAVIGATION_MAP)
//            KEY_NAVIGATION_PROFILE -> ProfileNavigationFragment.newInstance(KEY_NAVIGATION_PROFILE)
//            else -> throw NavigationException("Navigation container key doesn't exist")
//        }
    }

    companion object {
        const val KEY_NAVIGATION_QR = "KEY_NAVIGATION_QR"
        const val KEY_NAVIGATION_VENUES = "KEY_NAVIGATION_VENUES"
        const val KEY_NAVIGATION_CARDS = "KEY_NAVIGATION_CARDS"
        const val KEY_NAVIGATION_MAP = "KEY_NAVIGATION_MAP"
        const val KEY_NAVIGATION_PROFILE = "KEY_NAVIGATION_PROFILE"
    }

}