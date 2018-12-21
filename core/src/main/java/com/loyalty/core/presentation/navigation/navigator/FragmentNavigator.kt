package com.loyalty.core.presentation.navigation.navigator

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import com.loyalty.core.presentation.navigation.commands.BackNShow
import com.loyalty.core.presentation.navigation.commands.HideNAdd
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.commands.Command

abstract class FragmentNavigator(
        private val _fragmentManager: FragmentManager,
        @IdRes private val _containerId: Int
) : SupportFragmentNavigator(_fragmentManager, _containerId) {

    override fun showSystemMessage(message: String?) = Unit

    /* Primary navigation fragment is never null, as some fragment must always be active */
    override fun applyCommand(command: Command) {
        when (command) {
            is HideNAdd -> {
                _fragmentManager
                        .beginTransaction()
                        .hide(_fragmentManager.findFragmentById(_containerId)!!)
                        .add(_containerId, createFragment(command.screenKey, command.transitionData))
                        .addToBackStack(command.screenKey)
                        .commit()
            }
            is BackNShow -> {
                if (_fragmentManager.backStackEntryCount > 0) {
                    _fragmentManager.popBackStackImmediate()
                    _fragmentManager.beginTransaction()
                            .show(_fragmentManager.findFragmentById(_containerId)!!)
                            .commit()
                } else {
                    exit()
                }
            }
            else -> super.applyCommand(command)
        }
    }

}