package com.loyalty.customer.presentation.venues

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.setOnQueryChangedListener
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venues.adapter.VenuesAdapter
import com.loyalty.customer.ui.models.VenueItemUIModel
import kotlinx.android.synthetic.main.venues_fragment.searchVenues
import kotlinx.android.synthetic.main.venues_fragment.venuesEmpty
import kotlinx.android.synthetic.main.venues_fragment.venuesProgressBar
import kotlinx.android.synthetic.main.venues_fragment.venuesRecycler
import org.koin.android.viewmodel.ext.android.viewModel

class VenuesFragment : MvvmFragment<VenuesState, BaseEvent>() {

    override val layout: Int get() = R.layout.venues_fragment

    override val viewModel: VenuesViewModel by viewModel()

    private lateinit var venuesAdapter: VenuesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initViewModel()
        initViews()
    }

    private fun initViews() {
        searchVenues.setOnQueryChangedListener { query ->
            viewModel.filterVenues(query)
        }
        searchVenues.setOnCloseListener {
            searchVenues.setQuery("", true)
            searchVenues.clearFocus()
            false
        }
    }

    override fun processState(state: VenuesState) {
        super.processState(state)
        if (state.isLoading) {
            processLoadingState()
        } else if (state.isError) {
            processErrorState()
        } else if (!state.isLoading && !state.isError && state.venues.isEmpty()) {
            processEmptyState()
        } else if (!state.isLoading && !state.isError) {
            processLoadedState(state.venues)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun processLoadingState() {
        venuesRecycler.invisible()
        venuesEmpty.invisible()
        venuesProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(venues: List<VenueItemUIModel>) {
        venuesRecycler.visible()
        venuesEmpty.invisible()
        venuesProgressBar.gone()

        if (!::venuesAdapter.isInitialized) {
            initVenuesRecycler(venues)
        }
        venuesAdapter.setItems(venues)
    }

    private fun initVenuesRecycler(venues: List<VenueItemUIModel>) {
        venuesAdapter = VenuesAdapter(venues) { viewModel.selectVenue(it) }
        venuesRecycler.apply {
            adapter = venuesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun processEmptyState() {
        venuesRecycler.invisible()
        venuesEmpty.visible()
        venuesProgressBar.gone()
    }

    companion object {
        fun newInstance(): VenuesFragment = VenuesFragment()
    }

}