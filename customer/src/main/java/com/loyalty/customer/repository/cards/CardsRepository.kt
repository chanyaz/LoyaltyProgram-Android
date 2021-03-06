package com.loyalty.customer.repository.cards

import com.loyalty.customer.ui.models.card.CardItemUIModel
import io.reactivex.Single

interface CardsRepository {

    fun loadCards(): Single<List<CardItemUIModel>>

}