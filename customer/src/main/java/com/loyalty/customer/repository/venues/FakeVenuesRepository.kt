package com.loyalty.customer.repository.venues

import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeVenuesRepository : VenuesRepository {

    private val venues: List<VenueItemUIModel> = listOf(
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Calabria", "ул. Чачи, 57", "с 11.00 до 22.00"),
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Coffeeholic", "ул. Чачи, 23", "с 11.00 до 22.00"),
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Zerno", "ул. Чачи, 34", "с 11.00 до 22.00"),
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Expresso", "ул. Чачи, 666", "с 11.00 до 22.00"),
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Lolo4ka", "ул. Чачи, 45", "с 11.00 до 22.00"),
            VenueItemUIModel("https://img.grouponcdn.com/deal/usyc5qMhACid4zb7b34DdtkC4Vh/us-1374x824/v1/t440x300.jpg", "Wine ", "ул. Чачи, 77", "с 11.00 до 22.00")
    )

    override fun getVenues(city: String): Single<List<VenueItemUIModel>> {
        return Single.just(venues)
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
    }

}