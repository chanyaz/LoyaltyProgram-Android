package com.loyalty.customer.usecases.map

import com.google.android.gms.maps.model.LatLng
import com.loyalty.customer.ui.models.venue.VenueMapUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoadMapVenuesImpl : LoadMapVenues {

    private val venues: List<VenueMapUIModel> = listOf(
            VenueMapUIModel("1", "Coffeeholic", "Coffeeshop", 0.25, LatLng(53.863159, 27.478511)),
            VenueMapUIModel("2", "Zerno", "Coffeeshop", 3.13, LatLng(53.911084, 27.495945)),
            VenueMapUIModel("3", "Porno Mustache", "Night Club", 0.2, LatLng(53.896130, 27.565067)),
            VenueMapUIModel("4", "Flugegehaimen", "Coffeeshop", 2.11, LatLng(53.913753, 27.581905)),
            VenueMapUIModel("5", "Black Cat Coffee", "Coffeeshop", 14.89, LatLng(53.903423, 27.577438)),
            VenueMapUIModel("6", "Leather Club", "Night Club", 5.0, LatLng(53.908674, 27.526895))
    )

    override fun invoke(): Single<List<VenueMapUIModel>> =
            Single.just(venues)
                    .delay(300, TimeUnit.MILLISECONDS, Schedulers.io())

}