package com.loyalty.core.presentation.navigation.router

import com.loyalty.core.presentation.navigation.commands.BackNShow
import com.loyalty.core.presentation.navigation.commands.HideNAdd
import ru.terrakok.cicerone.Router

class Router : Router() {

    fun hideNAdd(screenKey: String, data: Any? = null) {
        executeCommand(HideNAdd(screenKey, data))
    }

    fun backNShow() {
        executeCommand(BackNShow())
    }

}