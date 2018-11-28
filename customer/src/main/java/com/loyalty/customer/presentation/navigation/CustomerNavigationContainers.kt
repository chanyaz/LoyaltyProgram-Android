package com.loyalty.customer.presentation.navigation

import com.loyalty.core.presentation.navigation.NavigationContainer
import com.loyalty.customer.R

enum class CustomerNavigationContainers : NavigationContainer {
    Qr {
        override val navigationItemId: Int = R.id.buttonNavigationQr
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Venues {
        override val navigationItemId: Int = R.id.buttonNavigationVenues
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Cards {
        override val navigationItemId: Int = R.id.buttonNavigationCards
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Map {
        override val navigationItemId: Int = R.id.buttonNavigationMap
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    },
    Profile {
        override val navigationItemId: Int = R.id.buttonNavigationProfile
        override val startingPoint: String = CustomerScreens.KEY_FIRST.name
    }
}

enum class CustomerScreens {
    KEY_FIRST,
    KEY_SECOND,
    KEY_THIRD
}