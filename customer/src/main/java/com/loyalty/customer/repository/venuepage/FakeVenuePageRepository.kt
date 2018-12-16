package com.loyalty.customer.repository.venuepage

import com.loyalty.customer.ui.models.VenueOptionUIModel
import com.loyalty.customer.ui.models.VenuePageUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeVenuePageRepository : VenuePageRepository {

    private val venuePageUIModel: VenuePageUIModel = VenuePageUIModel(
            imageUrl = "https://www.amsterdam-travel-guide.net/images/coffeeshops/coffeeshop-paradise-amsterdam-damstraat.jpg",
            name = "Paradise",
            type = "Кофешоп ;)",
            venueOptions = listOf(
                    VenueOptionUIModel(android.R.drawable.presence_online, "г. Минск, ул. Калиновского 66", null),
                    VenueOptionUIModel(android.R.drawable.presence_online, "с 11.00 до 2.00 / пт-сб с 18.00 до 4.00", null),
                    VenueOptionUIModel(android.R.drawable.presence_online, "+ 375 29 148 88 88", null),
                    VenueOptionUIModel(android.R.drawable.presence_online, "+ 375 17 274 74 22", null),
                    VenueOptionUIModel(android.R.drawable.presence_online, "+ 375 44 902 00 00", null),
                    VenueOptionUIModel(android.R.drawable.presence_online, "https://www.linkedin.com/", null)
            ),
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