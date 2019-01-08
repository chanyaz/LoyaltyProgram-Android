package com.loyalty.customer.repository.venues

import com.loyalty.customer.ui.models.venue.VenueItemUIModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeVenuesRepository : VenuesRepository {

    private val venues: List<VenueItemUIModel> = listOf(
            VenueItemUIModel("https://pbs.twimg.com/profile_images/3680186256/54047b12750379df67270f27d6f4faf0.jpeg", "Zerno", "Минск, пр-т Независимости, 46", "с 07.00 до 23.00"),
            VenueItemUIModel("https://comelite-arch.com/wp-content/uploads/2018/04/student-coffee-shop-design-8-256x256.jpg", "Coffeeholic", "Минск, ул. Якуба Коласа, 33", "с 08.00 до 22.00"),
            VenueItemUIModel("https://cdn131.picsart.com/282910112020201.jpg?c256x256", "Wake Up Coffee", "Минск, ул. В. Хоружей, 5", "с 08.00 до 23.00"),
            VenueItemUIModel("https://pbs.twimg.com/profile_images/3216825928/450dc141f7e16a3677bd186c14929ff5.jpeg", "Surf Coffee", "Минск, ул. Кирова, 19", "с 08.00 до 23.00"),
            VenueItemUIModel("https://barcentral.com.au/wp-content/uploads/bar-256x256.jpg", "La coffee", "Минск, ул. Козлова, 5", "с 08.00 до 23.00"),
            VenueItemUIModel("https://barcentral.com.au/wp-content/uploads/Imterior-shot-256x256.jpg", "CoffeeBerry", "Минск, ул. Интернациональная, 5", "с 08.00 до 23.00")
    )

    override fun getVenues(city: String): Single<List<VenueItemUIModel>> {
        return Single.just(venues)
                .delay(500, TimeUnit.MILLISECONDS, Schedulers.io())
    }

}