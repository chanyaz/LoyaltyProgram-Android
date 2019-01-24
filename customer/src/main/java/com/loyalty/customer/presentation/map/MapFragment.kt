package com.loyalty.customer.presentation.map

import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.venue.VenueMapUIModel
import kotlinx.android.synthetic.main.map_fragment.globalMap
import kotlinx.android.synthetic.main.map_fragment.globalMapContainer
import kotlinx.android.synthetic.main.map_fragment.mapProgressBar
import org.koin.android.viewmodel.ext.android.viewModel

class MapFragment : MvvmFragment<MapState, BaseEvent>() {

    override val layout: Int get() = R.layout.map_fragment

    override val viewModel: MapViewModel by viewModel()

    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        (childFragmentManager.findFragmentById(R.id.globalMap) as? SupportMapFragment)?.apply {
            getMapAsync { map ->
                googleMap = map
                googleMap.uiSettings.apply {
                    // todo zoom to user position if location preference is present
                    isScrollGesturesEnabled = true
                    isRotateGesturesEnabled = false
                    isZoomGesturesEnabled = true
                    isZoomControlsEnabled = false
                }
                viewModel.mapLoaded()
            }
        }
    }

    override fun renderState(state: MapState) {
        super.renderState(state)
        if (state.isError) {
            renderErrorState()
        } else if (!state.isMapLoaded || !state.isVenueListLoaded) {
            renderLoadingState()
        } else if (state.isMapLoaded && state.isVenueListLoaded) {
            renderLoadedState(state.venues)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderLoadingState() {
        mapProgressBar.visible()
    }

    private fun renderLoadedState(venues: List<VenueMapUIModel>) {
        mapProgressBar.gone()

        googleMap.clear()

        val boundsBuilder = LatLngBounds.builder()
        venues.forEach { venue ->
            boundsBuilder.include(venue.location)
            googleMap.addMarker(MarkerOptions().position(venue.location).title(venue.name))
        }
        val bounds = boundsBuilder.build()

        val width = calculateSide(globalMapContainer.width)
        val height = calculateSide(globalMapContainer.height)
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, width, height, 0)

        if (width > 0 && height > 0)
            googleMap.animateCamera(cameraUpdate)
    }

    private fun calculateSide(initialLength: Int): Int =
            initialLength * 3/4

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

}