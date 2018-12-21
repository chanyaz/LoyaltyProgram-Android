package com.loyalty.core.presentation.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loyalty.core.R
import com.loyalty.core.exceptions.NavigationException
import com.loyalty.core.presentation.navigation.subnavigation.LocalCiceroneHolder
import com.loyalty.core.presentation.base.view.BaseFragment
import com.loyalty.core.presentation.base.view.OnBackPressedListener
import com.loyalty.core.presentation.navigation.navigator.FragmentNavigator
import com.loyalty.core.presentation.navigation.router.Router
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator

abstract class NavigationFragment : Fragment(), OnBackPressedListener {

    /* *
     * The holder should be used only for obtaining Cicerone<Router> instance
     * */
    val ciceroneHolder: LocalCiceroneHolder by inject()
    val cicerone: Cicerone<Router> by lazy {
        ciceroneHolder.getCiceroneByTag(containerName)
    }

    abstract fun createFragment(screenKey: String, data: Any?): BaseFragment

    protected val containerName: String by lazy {
        arguments?.getString(KEY_EXTRA_CONTAINER_NAME) ?: throw NavigationException("Container name should be present")
    }

    protected val initialFragmentKey: String by lazy {
        arguments?.getString(KEY_EXTRA_INITIAL_FRAGMENT) ?: throw NavigationException("Initial fragment key should be present")
    }

    private val navigationContainerId: Int get() = R.id.navigationContainer

    private val navigator: Navigator by lazy {
        object : FragmentNavigator(childFragmentManager, navigationContainerId) {
            override fun createFragment(screenKey: String, data: Any?): Fragment =
                    this@NavigationFragment.createFragment(screenKey, data)
            override fun exit() = activity?.finish() ?: Unit
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.navigation_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(navigationContainerId) == null) {
            cicerone.router.replaceScreen(initialFragmentKey, null)
        }
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed(): Boolean {
        val fragment = childFragmentManager.findFragmentById(navigationContainerId)
        if ((fragment as? OnBackPressedListener)?.onBackPressed() == false) {
            (activity as? NavigationActivity)?.router?.exit()
        }
        return true
    }

    companion object {
        const val KEY_EXTRA_CONTAINER_NAME = "KEY_EXTRA_CONTAINER_NAME"
        const val KEY_EXTRA_INITIAL_FRAGMENT = "KEY_EXTRA_INITIAL_FRAGMENT"

        inline fun <reified NF : NavigationFragment> newInstance(navigationContainer: NavigationContainer, fragment: NF): NF {
            return fragment.apply {
                arguments = Bundle().apply {
                    putString(KEY_EXTRA_CONTAINER_NAME, navigationContainer.navigationFragmentName)
                    putString(KEY_EXTRA_INITIAL_FRAGMENT, navigationContainer.startingPoint)
                }
            }
        }
    }

}