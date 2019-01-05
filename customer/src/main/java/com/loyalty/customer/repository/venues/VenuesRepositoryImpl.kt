package com.loyalty.customer.repository.venues

import com.loyalty.customer.network.api.VenuesApi
import com.loyalty.customer.persistence.venues.VenuesStorage
import com.loyalty.customer.preferences.venuesversion.VenuesVPreferences
import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class VenuesRepositoryImpl(
        private val venuesApi: VenuesApi,
        private val venuesStorage: VenuesStorage,
        private val venuesVPreferences: VenuesVPreferences
) : VenuesRepository {

    override fun getVenues(city: String): Single<List<VenueItemUIModel>> =
            shouldUpdateVenues(city)
                    .flatMap {
                        if (it.shouldUpdateVenues) {
                            getAndSaveVenues(city, it)
                        } else {
                            venuesStorage.getVenues(city)
                        }
                    }

    private fun shouldUpdateVenues(city: String): Single<ShouldUpdateVenuesModel> =
            Single.zip(venuesApi.getVenuesVersion(city), venuesVPreferences.getVenuesVersion(city),
                    BiFunction { remoteVenuesVersion, localVenuesVersion ->
                        ShouldUpdateVenuesModel(
                                shouldUpdateVenues = remoteVenuesVersion == localVenuesVersion,
                                venuesVersion = remoteVenuesVersion
                        )
                    })

    private fun getAndSaveVenues(city: String, shouldUpdateVenuesModel: ShouldUpdateVenuesModel): Single<List<VenueItemUIModel>> {
        return venuesApi.getVenues(city)
                .doOnSuccess { venues -> // todo consider using .flatMap { venues -> and .toSingleDefault(venues) instead of doOnSuccess and blockingAwait
                    venuesStorage.clearVenues(city)
                            .andThen {
                                Completable.mergeArray(
                                        venuesStorage.saveVenues(city, venues),
                                        venuesVPreferences.saveVenuesVersion(city, shouldUpdateVenuesModel.venuesVersion)
                                )
                                it.onComplete()
                            }
                            .blockingAwait()
                }
    }

    private data class ShouldUpdateVenuesModel(
            val shouldUpdateVenues: Boolean,
            val venuesVersion: Long
    )

}