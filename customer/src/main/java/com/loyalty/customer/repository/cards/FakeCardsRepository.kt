package com.loyalty.customer.repository.cards

import com.loyalty.customer.ui.models.CardItemUIModel
import com.loyalty.customer.ui.models.EventType
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class FakeCardsRepository : CardsRepository {

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
                    "Kotlin Shop",
                    "Coffeeshop",
                    3,
                    "03.03-04.03",
                    EventType.COFFEE_STAMPS,
                    9,
                    10
            ),
            CardItemUIModel(
                    "http://javamark.com/wp-content/uploads/2016/03/Java-Mark-Logo-Color-png-2.png",
                    "Union Coffee",
                    "Coffeeshop",
                    2,
                    "02.02-03.03",
                    EventType.COFFEE_STAMPS,
                    14,
                    10
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

    override fun loadCards(): Single<List<CardItemUIModel>> =
            Single.just(cards)
                    .delay(1200, TimeUnit.MILLISECONDS, Schedulers.io())

}