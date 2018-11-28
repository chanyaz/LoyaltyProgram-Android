package com.loyalty.core.presentation.navigation

interface NavigationContainer {
    val navigationItemId: Int
    val startingPoint: String

    val navigationFragmentName: String
        get() = navigationItemId.toString()
}