package com.loyalty.customer.presentation.venue

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import org.koin.android.ext.android.inject
import com.loyalty.customer.presentation.cards.adapter.CardsAdapter
import com.loyalty.customer.presentation.venue.adapter.VenueInfoAdapter
import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import kotlinx.android.synthetic.main.venue_page_fragment.backButton
import kotlinx.android.synthetic.main.venue_page_fragment.venueCardsRecycler
import kotlinx.android.synthetic.main.venue_page_fragment.venueGroupContent
import kotlinx.android.synthetic.main.venue_page_fragment.venueInformationRecycler
import kotlinx.android.synthetic.main.venue_page_fragment.venueName
import kotlinx.android.synthetic.main.venue_page_fragment.venueProgressBar
import kotlinx.android.synthetic.main.venue_page_fragment.venueType

class VenuePageFragment : MvvmFragment<VenuePageState, BaseEvent>() {

    override val layout: Int get() =  R.layout.venue_page_fragment

    override val viewModel: VenuePageViewModel by inject()

    private lateinit var venueCardsAdapter: CardsAdapter
    private lateinit var venueInfoAdapter: VenueInfoAdapter

    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.initViewModel()
    }

    private fun initViews() {
        backButton.setOnClickListener {
            viewModel.back()
        }
        (childFragmentManager.findFragmentById(R.id.venueMap) as? SupportMapFragment)?.apply {
            getMapAsync { map ->
                googleMap = map
                googleMap.uiSettings.apply {
                    isScrollGesturesEnabled = false
                    isRotateGesturesEnabled = false
                    isZoomGesturesEnabled = false
                    isZoomControlsEnabled = true
                }
                viewModel.mapLoaded()
            }
        }
    }

    override fun processState(state: VenuePageState) {
        super.processState(state)
        if (state.isLoading) {
            processLoadingState()
        } else if (state.isError) {
            processErrorState()
        } else if (!state.isLoading && !state.isError && state.model != null) {
            processLoadedState(state.model)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun processLoadingState() {
        venueGroupContent.invisible()
        venueProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(model: VenuePageUIModel) {
        venueProgressBar.gone()
        venueGroupContent.visible()

        venueName.text = model.name
        venueType.text = model.type

        if (::googleMap.isInitialized) { // todo what if the map loads after the venue page
            googleMap.apply {
                clear()
                addMarker(MarkerOptions().position(model.location).title(model.name))
                moveCamera(CameraUpdateFactory.newLatLng(model.location))
                animateCamera(CameraUpdateFactory.zoomTo(15f))
            }
        }

        if (!::venueCardsAdapter.isInitialized)
            initCardsAdapter()

        if (!::venueInfoAdapter.isInitialized)
            initInformationAdapter()

        venueCardsAdapter.setItems(model.cards)
        venueInfoAdapter.setItems(model.venueInfoListUIModel)
    }

    private fun initCardsAdapter() {
        venueCardsAdapter = CardsAdapter {
//            viewModel.selectCard(it) // todo
        }
        venueCardsRecycler.apply {
            adapter = venueCardsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun initInformationAdapter() {
        venueInfoAdapter = VenueInfoAdapter()
        venueInformationRecycler.apply {
            adapter = venueInfoAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
    }

    companion object {
        fun newInstance(): VenuePageFragment = VenuePageFragment()
    }

}