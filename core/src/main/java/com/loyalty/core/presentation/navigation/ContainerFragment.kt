package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.BaseApp
import com.loyalty.core.R
import com.loyalty.core.presentation.navigation.subnavigation.LocalCiceroneHolder
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportFragmentNavigator

class ContainerFragment : Fragment() {

    val ciceroneHolder: LocalCiceroneHolder by inject()

    private val containerName: String by lazy {
        arguments?.getString(KEY_EXTRA_NAME) ?: throw RuntimeException("Container name should be present")
    }

    private val navigator: Navigator = object : SupportFragmentNavigator(childFragmentManager, R.id.navigationContainer) {
        override fun createFragment(screenKey: String?, data: Any?): Fragment {
            throw RuntimeException("Not yet implemented")
        }
        override fun exit() = activity?.finish() ?: Unit
        override fun showSystemMessage(message: String?) = Unit
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.navigation_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        childFragmentManager.findFragmentById(R.id.navigationContainer)?.let {

//            ciceroneHolder.getCiceroneByTag(containerName).router.replaceScreen(containerName, 0)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity?.application as? BaseApp)?.navigationHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        (activity?.application as? BaseApp)?.navigationHolder?.removeNavigator()
    }

    companion object {
        private const val KEY_EXTRA_NAME = "KEY_EXTRA_NAME"

        fun newInstance(name: String): ContainerFragment =
                ContainerFragment().apply {
                    arguments = Bundle().apply {
                        putString(KEY_EXTRA_NAME, name)
                    }
                }
    }

}