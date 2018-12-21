package com.loyalty.core.presentation.navigation.commands

import ru.terrakok.cicerone.commands.Command

/**
 * [HideNAdd] navigation command.
 *
 * @param screenKey      screen key
 * @param transitionData initial data
 */

class HideNAdd(val screenKey: String, val transitionData: Any?) : Command
