package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.BaseApp
import com.loyalty.core.R
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.navigation.subnavigation.LocalCiceroneHolder
import com.loyalty.core.presentation.view.BaseFragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportFragmentNavigator

abstract class NavigationFragment : Fragment() {

    val ciceroneHolder: LocalCiceroneHolder by inject()

    abstract fun createFragment(screenKey: String, data: Any?): BaseFragment<BaseState, BaseEvent>

    protected val containerName: String by lazy {
        arguments?.getString(KEY_EXTRA_CONTAINER_NAME) ?: throw RuntimeException("Container name should be present")
    }

    protected val initialFragmentKey: String by lazy {
        arguments?.getString(KEY_EXTRA_INITIAL_FRAGMENT) ?: throw RuntimeException("Initial fragment key should be present")
    }

    private val navigator: Navigator = object : SupportFragmentNavigator(childFragmentManager, R.id.navigationContainer) {
        override fun createFragment(screenKey: String, data: Any?): Fragment =
                this@NavigationFragment.createFragment(screenKey, data)
        override fun exit() = activity?.finish() ?: Unit
        override fun showSystemMessage(message: String?) = Unit
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.navigation_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        childFragmentManager.findFragmentById(R.id.navigationContainer)?.let {
            ciceroneHolder.getCiceroneByTag(containerName).router.replaceScreen(initialFragmentKey, null)
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
        protected const val KEY_EXTRA_CONTAINER_NAME = "KEY_EXTRA_CONTAINER_NAME"
        protected const val KEY_EXTRA_INITIAL_FRAGMENT = "KEY_EXTRA_INITIAL_FRAGMENT"

//        fun newInstance(containerName: String, initialFragmentKey: String): NavigationFragment =
//                NavigationFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(KEY_EXTRA_CONTAINER_NAME, containerName)
//                        putString(KEY_EXTRA_INITIAL_FRAGMENT, initialFragmentKey)
//                    }
//                }
    }

}