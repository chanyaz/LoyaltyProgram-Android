package com.loyalty.customer.repository.venuepage

import com.google.android.gms.maps.model.LatLng
import com.loyalty.customer.ui.models.CardItemUIModel
import com.loyalty.customer.ui.models.EventType
import com.loyalty.customer.ui.models.VenuePageUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeVenuePageRepository : VenuePageRepository {

    private val cards: List<CardItemUIModel> = listOf(
            CardItemUIModel(
                    "http://javamark.com/wp-content/uploads/2016/03/Java-Mark-Logo-Color-png-2.png",
                    "Java Shop",
                    "Coffeeshop",
                    2,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    13,
                    14
            ),
            CardItemUIModel(
                    "http://javamark.com/wp-content/uploads/2016/03/Java-Mark-Logo-Color-png-2.png",
                    "Zerno",
                    "Coffeeshop",
                    22,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    13,
                    14
            )
    )

    private val fakeVenuePageUIModel: VenuePageUIModel = VenuePageUIModel(
            name = "Coffeeholic",
            type = "Ресторан и пиццерия",
            imageUrls = listOf(
                    "https://c1.staticflickr.com/3/2291/2407610845_92a010d53e_b.jpg",
                    "https://c8.alamy.com/comp/G3F2TH/rembrandtplein-coffee-shop-amsterdam-holland-netherlands-G3F2TH.jpg",
                    "https://c8.alamy.com/comp/A09JPD/coffeeshop-amsterdam-A09JPD.jpg"
            ),
            cards = cards,
            addresses = listOf(),
            schedules = listOf(),
            phones = listOf(),
            website = listOf(),
            location = LatLng(53.896078, 27.556120),
            description = "Высокий уровень обслуживания, приятная обстановка, приветливый персонал, кофе и чай разных сортов."
    )

    override fun loadVenuePage(id: String): Single<VenuePageUIModel> =
            Single.just(fakeVenuePageUIModel)
                    .delay(300, TimeUnit.MILLISECONDS, Schedulers.io())

}