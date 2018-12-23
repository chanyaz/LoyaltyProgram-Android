package com.loyalty.customer.presentation.venue

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.presentation.venue.adapter.images.VenueImagesAdapter
import com.loyalty.customer.presentation.venue.adapter.options.VenueOptionsAdapter
import com.loyalty.customer.ui.models.VenuePageUIModel
import kotlinx.android.synthetic.main.venue_fragment.backButton
import kotlinx.android.synthetic.main.venue_fragment.venueAboutText
import kotlinx.android.synthetic.main.venue_fragment.venueCardsInThisVenue
import kotlinx.android.synthetic.main.venue_fragment.venueCardsInThisVenueText
import kotlinx.android.synthetic.main.venue_fragment.venueImage
import kotlinx.android.synthetic.main.venue_fragment.venueImagesRecycler
import kotlinx.android.synthetic.main.venue_fragment.venueName
import kotlinx.android.synthetic.main.venue_fragment.venueOptionsRecycler
import kotlinx.android.synthetic.main.venue_fragment.venueProgressBar
import kotlinx.android.synthetic.main.venue_fragment.venueType
import org.koin.android.ext.android.inject
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.venue_fragment.venueMapContainer

class VenueFragment : MvvmFragment<VenueState, BaseEvent>() {

    override val layout: Int get() =  R.layout.venue_fragment

    override val viewModel: VenueViewModel by inject()

    private lateinit var groupContent: List<View>

    private lateinit var venueOptionsAdapter: VenueOptionsAdapter
    private lateinit var venueImagesAdapter: VenueImagesAdapter

    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.initViewModel()
    }

    private fun initViews() {
        groupContent = listOf(
                venueImage, venueName, venueType, venueCardsInThisVenueText, venueCardsInThisVenue,
                venueAboutText, venueOptionsRecycler, venueImagesRecycler, venueMapContainer
        )
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

    override fun processState(state: VenueState) {
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
        groupContent.invisible()
        venueProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processLoadedState(model: VenuePageUIModel) {
        venueProgressBar.gone()
        groupContent.visible()

        Glide.with(this).load(model.imageUrl).into(venueImage)
        venueName.text = model.name
        venueType.text = model.type

        if (!::venueOptionsAdapter.isInitialized)
            initVenueOptionsRecycler()

        if (!::venueImagesAdapter.isInitialized)
            initVenueImagesRecycler()

        venueOptionsAdapter.setItems(model.venueOptions)
        venueImagesAdapter.setItems(model.images)

        if (::googleMap.isInitialized) {
            googleMap.apply {
                clear()
                addMarker(MarkerOptions().position(model.location).title(model.name))
                moveCamera(CameraUpdateFactory.newLatLng(model.location))
                animateCamera(CameraUpdateFactory.zoomTo(15f))
            }
        }
    }

    private fun initVenueOptionsRecycler() {
        venueOptionsAdapter = VenueOptionsAdapter()
        venueOptionsRecycler.apply {
            adapter = venueOptionsAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
    }

    private fun initVenueImagesRecycler() {
        venueImagesAdapter = VenueImagesAdapter()
        venueImagesRecycler.apply {
            adapter = venueImagesAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    companion object {
        fun newInstance(): VenueFragment = VenueFragment()
    }

}