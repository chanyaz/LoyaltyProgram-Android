package com.loyalty.customer.repository.venuepage

import com.google.android.gms.maps.model.LatLng
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.card.CardItemUIModel
import com.loyalty.customer.ui.models.card.EventType
import com.loyalty.customer.ui.models.venue.VenueImageUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoAddressUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeaderUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoPhoneUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoScheduleUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoSeparatorUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoWebsiteUIModel
import com.loyalty.customer.ui.models.venue.VenuePageUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoDescriptionUIModel
import com.loyalty.customer.ui.models.venue.information.VenueInfoHeader2UIModel
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
            )
    )

    private val fakeVenuePageUIModel: VenuePageUIModel = VenuePageUIModel(
            name = "Coffeeholic",
            type = "Ресторан и пиццерия",
            imageUrls = listOf(
                    VenueImageUIModel("https://ms1.relax.by/images/5da23058500fe4a6857e31cd0906d449/resize/w=1200,h=800,q=80,watermark=true/place_gallery_photo/d1/80/4d/d1804d0455b1486af0202214064fbac0.jpg"),
                    VenueImageUIModel("https://ms1.relax.by/images/5da23058500fe4a6857e31cd0906d449/resize/w=1200,h=800,q=80,watermark=true/place_gallery_photo/af/d6/c1/afd6c1215dc8418b73856caab0716e51.jpg"),
                    VenueImageUIModel("https://ms1.relax.by/images/5da23058500fe4a6857e31cd0906d449/resize/w=1200,h=800,q=80,watermark=true/place_gallery_photo/ee/28/1a/ee281a3fee06ae4a54701c335063341c.jpg")
            ),
            cards = cards,
            venueInfoListUIModel = listOf( // todo move this to use case
                    VenueInfoHeaderUIModel("Адрес", R.drawable.ic_location),
                    VenueInfoAddressUIModel("г. Минск, ул. Калиновского, 24"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Время работы", R.drawable.ic_schedule),
                    VenueInfoScheduleUIModel("Будние", "с 11.00 до 2.00"),
                    VenueInfoScheduleUIModel("Выходные", "с 18.00 до 5.00"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Телефоны", R.drawable.ic_phone),
                    VenueInfoPhoneUIModel("+ 375 (33) 202 03 27"),
                    VenueInfoPhoneUIModel("+ 375 (44) 202 03 27"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Веб-Сайт", R.drawable.ic_website),
                    VenueInfoWebsiteUIModel("www.calabria.by"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeader2UIModel("Описание"),
                    VenueInfoDescriptionUIModel("Высокий уровень обслуживания, приятная обстановка, приветливый персонал, кофе и чай разных сортов.")
                    ),
            location = LatLng(53.896078, 27.556120)
    )

    override fun loadVenuePage(id: String): Single<VenuePageUIModel> =
            Single.just(fakeVenuePageUIModel)
                    .delay(300, TimeUnit.MILLISECONDS, Schedulers.io())

}