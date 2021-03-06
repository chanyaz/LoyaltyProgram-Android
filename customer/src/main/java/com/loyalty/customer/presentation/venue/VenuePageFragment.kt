package com.loyalty.customer.presentation.venue

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.setOnCollapseListener
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import org.koin.android.ext.android.inject
import com.loyalty.customer.presentation.cards.adapter.CardsAdapter
import com.loyalty.customer.presentation.venue.adapter.VenueInfoAdapter
import com.loyalty.customer.presentation.venue.pager.VenueImagesAdapter
import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import kotlinx.android.synthetic.main.venue_page_fragment.backButton
import kotlinx.android.synthetic.main.venue_page_fragment.toolbarSubtitle
import kotlinx.android.synthetic.main.venue_page_fragment.toolbarTitle
import kotlinx.android.synthetic.main.venue_page_fragment.venueCardsRecycler
import kotlinx.android.synthetic.main.venue_page_fragment.venueGroupContent
import kotlinx.android.synthetic.main.venue_page_fragment.venueImagesPager
import kotlinx.android.synthetic.main.venue_page_fragment.venueImagesTabs
import kotlinx.android.synthetic.main.venue_page_fragment.venueInformationRecycler
import kotlinx.android.synthetic.main.venue_page_fragment.venueName
import kotlinx.android.synthetic.main.venue_page_fragment.venuePageAppBarLayout
import kotlinx.android.synthetic.main.venue_page_fragment.venuePageLayout
import kotlinx.android.synthetic.main.venue_page_fragment.venueProgressBar
import kotlinx.android.synthetic.main.venue_page_fragment.venueType

class VenuePageFragment : MvvmFragment<VenuePageState, VenuePageEvent>() {

    override val layout: Int get() =  R.layout.venue_page_fragment

    override val viewModel: VenuePageViewModel by inject()

    private val venueImagesAdapter: VenueImagesAdapter by lazy { VenueImagesAdapter(activity) }
    private val venueCardsAdapter: CardsAdapter = CardsAdapter { /* todo */ }
    private val venueInfoAdapter: VenueInfoAdapter = VenueInfoAdapter {
        viewModel.venueOptionClicked(it)
    }

    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
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
        venueImagesTabs.setupWithViewPager(venueImagesPager, true)
        venuePageAppBarLayout.setOnCollapseListener(
                onCollapse = { viewModel.showToolbarTitles() },
                onExpand = { viewModel.hideToolbarTitles() }
        )
        venueCardsRecycler.apply {
            adapter = venueCardsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        venueInformationRecycler.apply {
            adapter = venueInfoAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        venueImagesPager.adapter = venueImagesAdapter
        ViewCompat.requestApplyInsets(venuePageLayout)
    }

    override fun triggerEvent(event: VenuePageEvent) {
        super.triggerEvent(event)
        startActivity(event.intent)
    }

    override fun renderState(state: VenuePageState) {
        super.renderState(state)
        if (state.isError) {
            renderErrorState()
        } else if (state.isLoading) {
            renderLoadingState()
        } else if (!state.isLoading && !state.isError && state.model != null) {
            renderLoadedState(state.model, state.shouldDrawMap.value)
        } else {
            throw UnexpectedStateException(state.toString())
        }

        renderToolbarState(state.areToolbarTitlesShown)
    }

    private fun renderLoadingState() {
        venueGroupContent.invisible()
        venueProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderLoadedState(model: VenuePageUIModel, shouldDrawMap: Boolean) {
        venueProgressBar.gone()
        venueGroupContent.visible()

        venueName.text = model.name
        toolbarTitle.text = model.name

        venueType.text = model.type
        toolbarSubtitle.text = model.type

        if (shouldDrawMap) {
            googleMap.apply {
                clear()
                addMarker(MarkerOptions().position(model.location).title(model.name))
                moveCamera(CameraUpdateFactory.newLatLng(model.location))
                animateCamera(CameraUpdateFactory.zoomTo(15f))
            }
        }

        if (venueImagesAdapter.images.isEmpty()) {
            venueImagesAdapter.apply {
                images = model.imageUrls
                notifyDataSetChanged()
            }
        }

        venueCardsAdapter.items = model.cards
        venueInfoAdapter.items = model.venueInfoListUIModel
    }

    private fun renderToolbarState(areToolbarTitlesShown: Boolean) {
        if (areToolbarTitlesShown) {
            toolbarTitle.visible()
            toolbarSubtitle.visible()
        } else {
            toolbarTitle.invisible()
            toolbarSubtitle.invisible()
        }
    }

    companion object {
        fun newInstance(): VenuePageFragment = VenuePageFragment()
    }

}