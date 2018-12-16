package com.loyalty.customer.presentation.venue

import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.base.BaseState
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.customer.R
import org.koin.android.ext.android.inject

class VenueFragment : MvvmFragment<BaseState, BaseEvent>() {

    override val layout: Int get() =  R.layout.venue_fragment

    override val viewModel: VenueViewModelImpl by inject()



    companion object {
        fun newInstance(): VenueFragment = VenueFragment()
    }

}