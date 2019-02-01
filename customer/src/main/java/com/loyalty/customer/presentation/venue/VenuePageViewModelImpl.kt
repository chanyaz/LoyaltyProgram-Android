package com.loyalty.customer.presentation.venue

import android.content.Intent
import android.net.Uri
import com.loyalty.core.util.SingleEventFlag
import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoPhoneUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoWebsiteUIModel
import com.loyalty.customer.usecases.venue.LoadVenuePage
import timber.log.Timber
import java.util.Locale

class VenuePageViewModelImpl(
        private val loadVenuePage: LoadVenuePage
) : VenuePageViewModel() {

    override val initialState: VenuePageState get() = VenuePageState()

    init {
        loadVenue()
    }

    private fun loadVenue() {
        subscribe(loadVenuePage("")
                .observeOnUi()
                .subscribe(::onLoadVenueSuccess, ::onLoadVenueError)
        )
    }

    private fun onLoadVenueSuccess(venue: VenuePageUIModel) {
        setState(currentState.copy(model = venue, isLoading = false, isError = false))
    }

    private fun onLoadVenueError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

    override fun mapLoaded() {
        setState(currentState.copy(shouldDrawMap = SingleEventFlag(true)))
    }

    override fun venueOptionClicked(position: Int) {
        val itemClicked = currentState.model?.venueInfoListUIModel?.get(position)
        itemClicked?.let {
            triggerEvent(VenuePageEvent(
                    when (it) {
                        is VenueInfoWebsiteUIModel -> Intent(Intent.ACTION_VIEW, Uri.parse(it.website)) // todo handle the formats
                        is VenueInfoPhoneUIModel -> Intent(Intent.ACTION_DIAL, Uri.parse("tel:${it.phone}"))
                        is VenueInfoAddressUIModel -> Intent(Intent.ACTION_VIEW, Uri.parse(String.format(Locale.ENGLISH, "geo:%f,%f", currentState.model!!.location.latitude, currentState.model!!.location.longitude)))
                        else -> throw RuntimeException("Something wrong with option position")
                    }
            ))
        }
    }

    override fun back() {
        router.backNShow()
    }

    override fun hideToolbarTitles() {
        setState(currentState.copy(areToolbarTitlesShown = false))
    }

    override fun showToolbarTitles() {
        setState(currentState.copy(areToolbarTitlesShown = true))
    }
}