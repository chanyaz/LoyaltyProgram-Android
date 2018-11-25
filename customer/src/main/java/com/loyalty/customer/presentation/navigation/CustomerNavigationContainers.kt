package com.loyalty.customer.presentation.navigation

import com.loyalty.core.presentation.navigation.NavigationContainer

enum class CustomerNavigationContainers : NavigationContainer {
    Qr {
        override val navigationFragmentName: String = CustomerTabs.KEY_NAVIGATION_QR.name
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Venues {
        override val navigationFragmentName: String = CustomerTabs.KEY_NAVIGATION_VENUES.name
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Cards {
        override val navigationFragmentName: String = CustomerTabs.KEY_NAVIGATION_CARDS.name
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Map {
        override val navigationFragmentName: String = CustomerTabs.KEY_NAVIGATION_MAP.name
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Profile {
        override val navigationFragmentName: String = CustomerTabs.KEY_NAVIGATION_PROFILE.name
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    }
}

enum class CustomerTabs {
    KEY_NAVIGATION_QR,
    KEY_NAVIGATION_VENUES,
    KEY_NAVIGATION_CARDS,
    KEY_NAVIGATION_MAP,
    KEY_NAVIGATION_PROFILE
}

enum class CustomerScreens {
    KEY_FIRST,
    KEY_SECOND,
    KEY_THIRD
}