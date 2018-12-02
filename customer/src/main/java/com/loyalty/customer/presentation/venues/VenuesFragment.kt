package com.loyalty.customer.presentation.venues

import android.os.Bundle
import android.view.View
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.customer.R
import kotlinx.android.synthetic.main.venues_fragment.venuesRecycler
import org.koin.android.viewmodel.ext.android.viewModel

class VenuesFragment : MvvmFragment<VenuesState, VenuesEvent>() {

    override val layout: Int get() = R.layout.venues_fragment

    override val viewModel: VenuesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initViewModel()
    }

    private fun initViews() {
        venuesRecycler.adapter
    }

    override fun processState(state: VenuesState) {
        super.processState(state)
        TODO()
    }

    override fun processEvent(event: VenuesEvent) {
        super.processEvent(event)
        TODO()
    }
}