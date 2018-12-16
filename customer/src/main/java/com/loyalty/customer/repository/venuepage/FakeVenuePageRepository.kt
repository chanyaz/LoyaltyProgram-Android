package com.loyalty.customer.repository.venuepage

import com.loyalty.customer.ui.models.VenuePageUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeVenuePageRepository : VenuePageRepository {

    private val venuePageUIModel: VenuePageUIModel = VenuePageUIModel(
            imageUrl = "https://www.amsterdam-travel-guide.net/images/coffeeshops/coffeeshop-paradise-amsterdam-damstraat.jpg",
            name = "Paradise",
            type = "Кофешоп ;)",
            address = "г. Минск, ул. Калиновского 66",
            workingHours = "с 11.00 до 2.00 / пт-сб с 18.00 до 4.00",
            phones = listOf("+ 375 29 148 88 88", "+ 375 17 274 74 22", "+ 375 44 902 00 00"),
            website = "https://www.linkedin.com/",
            images = listOf(
                    "https://c1.staticflickr.com/3/2291/2407610845_92a010d53e_b.jpg",
                    "https://c8.alamy.com/comp/G3F2TH/rembrandtplein-coffee-shop-amsterdam-holland-netherlands-G3F2TH.jpg",
                    "https://c8.alamy.com/comp/A09JPD/coffeeshop-amsterdam-A09JPD.jpg"
            ),
            latitude = 53.896078,
            longitude = 27.556120
    )

    override fun loadVenuePage(id: String): Single<VenuePageUIModel> =
            Single.just(venuePageUIModel)
                    .delay(1200, TimeUnit.MILLISECONDS, Schedulers.io())

}