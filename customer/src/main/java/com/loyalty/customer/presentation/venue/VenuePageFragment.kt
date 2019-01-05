package com.loyalty.customer.presentation.venue

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import org.koin.android.ext.android.inject
import com.loyalty.customer.presentation.cards.adapter.CardsAdapter
import com.loyalty.customer.presentation.venue.adapter.VenueInformationAdapter
import com.loyalty.customer.ui.models.VenueInformationAddressUIModel
import com.loyalty.customer.ui.models.VenueInformationHeaderUIModel
import com.loyalty.customer.ui.models.VenueInformationPhoneUIModel
import com.loyalty.customer.ui.models.VenueInformationScheduleUIModel
import com.loyalty.customer.ui.models.VenueInformationSeparatorUIModel
import com.loyalty.customer.ui.models.VenueInformationWebsiteUIModel
import com.loyalty.customer.ui.models.VenuePageUIModel
import kotlinx.android.synthetic.main.venue_page_fragment_new.backButton
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueCardsRecycler
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueGroupContent
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueInformationRecycler
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueName
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueProgressBar
import kotlinx.android.synthetic.main.venue_page_fragment_new.venueType

class VenuePageFragment : MvvmFragment<VenuePageState, BaseEvent>() {

    override val layout: Int get() =  R.layout.venue_page_fragment_new

    override val viewModel: VenuePageViewModel by inject()

    private lateinit var venueCardsAdapter: CardsAdapter
    private lateinit var venueInformationAdapter: VenueInformationAdapter

//    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.initViewModel()
    }

    private fun initViews() {
        backButton.setOnClickListener {
            viewModel.back()
        }
//        (childFragmentManager.findFragmentById(R.id.venueMap) as? SupportMapFragment)?.apply {
//            getMapAsync { map ->
//                googleMap = map
//                googleMap.uiSettings.apply {
//                    isScrollGesturesEnabled = false
//                    isRotateGesturesEnabled = false
//                    isZoomGesturesEnabled = false
//
//                    isZoomControlsEnabled = true
//                }
//                viewModel.mapLoaded()
//            }
//        }
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

//        if (::googleMap.isInitialized) {
//            googleMap.apply {
//                clear()
//                addMarker(MarkerOptions().position(model.location).title(model.name))
//                moveCamera(CameraUpdateFactory.newLatLng(model.location))
//                animateCamera(CameraUpdateFactory.zoomTo(15f))
//            }
//        }

        if (!::venueCardsAdapter.isInitialized)
            initCardsAdapter()

        if (!::venueInformationAdapter.isInitialized)
            initInformationAdapter()

        venueCardsAdapter.setItems(model.cards)
        venueInformationAdapter.setItems(listOf( // todo
                VenueInformationHeaderUIModel("Адрес", R.drawable.ic_location),
                VenueInformationAddressUIModel("г. Минск, ул. Калиновского, 24"),
                VenueInformationSeparatorUIModel(),
                VenueInformationHeaderUIModel("Время работы", R.drawable.ic_schedule),
                VenueInformationScheduleUIModel("Будние", "с 11.00 до 2.00"),
                VenueInformationScheduleUIModel("Выходные", "с 18.00 до 5.00"),
                VenueInformationSeparatorUIModel(),
                VenueInformationHeaderUIModel("Телефоны", R.drawable.ic_phone),
                VenueInformationPhoneUIModel("+ 375 (33) 202 03 27"),
                VenueInformationPhoneUIModel("+ 375 (44) 202 03 27"),
                VenueInformationSeparatorUIModel(),
                VenueInformationHeaderUIModel("Веб-Сайт", R.drawable.ic_website),
                VenueInformationWebsiteUIModel("www.calabria.by"),
                VenueInformationSeparatorUIModel()
                ))
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
        venueInformationAdapter = VenueInformationAdapter()
        venueInformationRecycler.apply {
            adapter = venueInformationAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

//    private fun initVenueImagesRecycler() {
//        venueImagesAdapter = VenueImagesAdapter()
//        venueImagesRecycler.apply {
//            adapter = venueImagesAdapter
//            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//            setHasFixedSize(true)
//        }
//    }

    companion object {
        fun newInstance(): VenuePageFragment = VenuePageFragment()
    }

}