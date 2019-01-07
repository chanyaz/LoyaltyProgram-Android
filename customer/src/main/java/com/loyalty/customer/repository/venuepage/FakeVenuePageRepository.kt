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
                    "https://us.123rf.com/450wm/arcady31/arcady311202/arcady31120200035/12414954-znak-przerwa-kawowa.jpg",
                    "Surf Coffee",
                    "Кофейня",
                    2,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    13,
                    14
            )
    )

    private val fakeVenuePageUIModel: VenuePageUIModel = VenuePageUIModel(
            name = "Surf Coffee",
            type = "Кофейня",
            imageUrls = listOf(
                    VenueImageUIModel("https://static.relax.by/images/common/wysiwyg/2016/07/e4c23b9772521cb152653112b7f56c6d.jpg"),
                    VenueImageUIModel("https://static.relax.by/images/common/wysiwyg/2016/07/85abafe684f2cf55aab17ed67417eefa.jpg"),
                    VenueImageUIModel("https://static.relax.by/images/common/wysiwyg/2016/07/9559c54abfd4bdc9acf7f37435231784.jpg")
            ),
            cards = cards,
            venueInfoListUIModel = listOf( // todo move this to use case
                    VenueInfoHeaderUIModel("Адрес", R.drawable.ic_location),
                    VenueInfoAddressUIModel("Минск, ул. Кирова, 19"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Время работы", R.drawable.ic_schedule),
                    VenueInfoScheduleUIModel("Будние", "с 08.00 до 23.00"),
                    VenueInfoScheduleUIModel("Выходные", "с 10.00 до 23.00"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Телефоны", R.drawable.ic_phone),
                    VenueInfoPhoneUIModel("+ 375 (33) 202 03 27"),
                    VenueInfoPhoneUIModel("+ 375 (44) 202 03 27"),
                    VenueInfoSeparatorUIModel(),
                    VenueInfoHeaderUIModel("Веб-Сайт", R.drawable.ic_website),
                    VenueInfoWebsiteUIModel("https://surfcoffee.relax.by/"),
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