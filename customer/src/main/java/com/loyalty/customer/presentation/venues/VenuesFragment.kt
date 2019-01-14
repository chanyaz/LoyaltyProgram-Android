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
import com.loyalty.customer.presentation.venues.adapter.VenueAdapter
import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import kotlinx.android.synthetic.main.venues_fragment.searchVenues
import kotlinx.android.synthetic.main.venues_fragment.toolbarSubtitle
import kotlinx.android.synthetic.main.venues_fragment.toolbarTitle
import kotlinx.android.synthetic.main.venues_fragment.venuesEmpty
import kotlinx.android.synthetic.main.venues_fragment.venuesProgressBar
import kotlinx.android.synthetic.main.venues_fragment.venuesRecycler
import org.koin.android.viewmodel.ext.android.viewModel

class VenuesFragment : MvvmFragment<VenuesState, BaseEvent>() {

    override val layout: Int get() = R.layout.venues_fragment

    override val viewModel: VenuesViewModel by viewModel()

    private lateinit var venuesAdapter: VenueAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initViewModel()
        initViews()
    }

    private fun initViews() {
        searchVenues.apply {
            setOnQueryChangedListener { query ->
                viewModel.filterVenues(query)
            }
            setOnCloseListener {
                searchVenues.setQuery("", true)
                searchVenues.clearFocus()
                viewModel.closeSearch()
                false
            }
            setOnSearchClickListener {
                viewModel.openSearch()
            }
        }
    }

    override fun renderState(state: VenuesState) {
        super.renderState(state)
        if (state.isLoading) {
            renderLoadingState()
        } else if (state.isError) {
            renderErrorState()
        } else if (!state.isLoading && !state.isError && state.venues.isEmpty()) {
            renderEmptyState()
        } else if (!state.isLoading && !state.isError) {
            renderLoadedState(state.venues)
        } else {
            throw UnexpectedStateException(state.toString())
        }

        processToolbarState(state.isSearchOpen)
    }

    private fun renderLoadingState() {
        venuesRecycler.invisible()
        venuesEmpty.invisible()
        venuesProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderLoadedState(venues: List<VenueItemUIModel>) {
        venuesRecycler.visible()
        venuesEmpty.invisible()
        venuesProgressBar.gone()

        toolbarSubtitle.text = resources.getQuantityString(R.plurals.venues_plurals, venues.size, venues.size)

        if (!::venuesAdapter.isInitialized)
            initVenuesRecycler()

        venuesAdapter.items = venues
    }

    private fun initVenuesRecycler() {
        venuesAdapter = VenueAdapter { viewModel.selectVenue(it) }
        venuesRecycler.apply {
            adapter = venuesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun renderEmptyState() {
        venuesRecycler.invisible()
        venuesEmpty.visible()
        venuesProgressBar.gone()
    }

    private fun processToolbarState(isSearchOpen: Boolean) {
        if (isSearchOpen) {
            toolbarSubtitle.invisible()
            toolbarTitle.invisible()
        } else {
            toolbarSubtitle.visible()
            toolbarTitle.visible()
        }
    }

    companion object {
        fun newInstance(): VenuesFragment = VenuesFragment()
    }

}