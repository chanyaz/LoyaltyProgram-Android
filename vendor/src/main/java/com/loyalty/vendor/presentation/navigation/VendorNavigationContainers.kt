package com.loyalty.vendor.presentation.navigation

import com.loyalty.core.presentation.navigation.NavigationContainer
import com.loyalty.vendor.R

enum class VendorNavigationContainers : NavigationContainer {
    SCAN {
        override val navigationItemId: Int = R.id.buttonNavigationScan
        override val startingPoint: String = VendorScreens.KEY_SCAN.name
    }
}

enum class VendorScreens {
    KEY_SCAN
}