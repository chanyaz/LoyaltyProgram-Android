package com.loyalty.customer.presentation.venues

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.exhaustive
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venues.adapter.VenuesAdapter
import kotlinx.android.synthetic.main.venues_fragment.venuesEmpty
import kotlinx.android.synthetic.main.venues_fragment.venuesProgressBar
import kotlinx.android.synthetic.main.venues_fragment.venuesRecycler
import org.koin.android.viewmodel.ext.android.viewModel

class VenuesFragment : MvvmFragment<VenuesState, VenuesEvent>() {

    override val layout: Int get() = R.layout.venues_fragment

    override val viewModel: VenuesViewModel by viewModel()

    private lateinit var venuesAdapter: VenuesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initViewModel()
    }

    override fun processState(state: VenuesState) {
        super.processState(state)
        when (state) {
            VenuesState.VenuesEmpty -> processEmptyState()
            VenuesState.VenuesLoading -> processLoadingState()
            VenuesState.VenuesError -> processErrorState()
            is VenuesState.VenuesLoaded -> processLoadedState(state)
        }.exhaustive
    }

    private fun processEmptyState() {
        venuesRecycler.gone()
        venuesEmpty.visible()
        venuesProgressBar.gone()
    }

    private fun processLoadingState() {
        venuesRecycler.gone()
        venuesEmpty.gone()
        venuesProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(state: VenuesState.VenuesLoaded) {
        venuesRecycler.visible()
        venuesEmpty.gone()
        venuesProgressBar.gone()

        if (!::venuesAdapter.isInitialized) {
            venuesAdapter = VenuesAdapter(state.venues)
            venuesRecycler.adapter = venuesAdapter
            venuesRecycler.layoutManager = LinearLayoutManager(activity)
        }
        venuesAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(): VenuesFragment = VenuesFragment()
    }

}