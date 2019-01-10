package com.loyalty.vendor.presentation.navigation

import com.loyalty.core.presentation.navigation.NavigationContainer
import com.loyalty.vendor.R

enum class CustomerNavigationContainers : NavigationContainer {
    Qr {
        override val navigationItemId: Int = R.id.buttonNavigationQr
        override val startingPoint: String = CustomerScreens.KEY_QR.name
    }
}

enum class CustomerScreens {
    KEY_QR
}