package com.loyalty.core.presentation.navigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.loyalty.core.inline.ViewId
import com.loyalty.core.presentation.BaseEvent
import com.loyalty.core.presentation.BaseState
import com.loyalty.core.presentation.view.BaseFragment

class NavigationAdapter(navigationStacks: List<Pair<ViewId, BaseFragment<BaseState, BaseEvent>>>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val navigationFragments: MutableList<ContainerFragment> = mutableListOf()

    init {
        for (number in 1..navigationStacks.size)
            navigationFragments.add(ContainerFragment())
    }

    override fun getItem(position: Int): Fragment = navigationFragments[position]

    override fun getCount(): Int = navigationFragments.size

}