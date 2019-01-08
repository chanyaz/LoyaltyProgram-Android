package com.loyalty.customer.repository.cards

import com.loyalty.customer.ui.models.card.CardItemUIModel
import com.loyalty.customer.ui.models.card.EventType
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeCardsRepository : CardsRepository {

    private val cards: List<CardItemUIModel> = listOf(
            CardItemUIModel(
                    "https://media-cdn.tripadvisor.com/media/photo-s/09/00/42/4f/lamppost-coffee.jpg",
                    "Lamppost Coffee",
                    "Кофейня",
                    5,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    13,
                    10
            ),
            CardItemUIModel(
                    "https://us.123rf.com/450wm/arcady31/arcady311202/arcady31120200035/12414954-znak-przerwa-kawowa.jpg",
                    "Surf Coffee",
                    "Кофейня",
                    3,
                    "03.03-04.03",
                    EventType.COFFEE_STAMPS,
                    9,
                    10
            ),
            CardItemUIModel(
                    "http://bridgeviewcoffeebar.com/assets/img/Logo_Round5a.png",
                    "Bridge View Coffee Bar",
                    "Кофейня",
                    2,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    14,
                    8
            ),
            CardItemUIModel(
                    "https://99designs-blog.imgix.net/wp-content/uploads/2017/05/attachment_82713536-e1493764721590.png?auto=format&q=60&fit=max&w=930",
                    "Refuge Coffee",
                    "Кофейня",
                    22,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    7,
                    10
            )
    )

    override fun loadCards(): Single<List<CardItemUIModel>> =
            Single.just(cards)
                    .delay(500, TimeUnit.MILLISECONDS, Schedulers.io())

}