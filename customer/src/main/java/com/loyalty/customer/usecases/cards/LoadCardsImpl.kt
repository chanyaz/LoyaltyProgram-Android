package com.loyalty.customer.usecases.cards

import com.loyalty.customer.preferences.location.LocationPreferences
import com.loyalty.customer.repository.cards.CardsRepository
import com.loyalty.customer.ui.models.CardItemUIModel
import io.reactivex.Single

class LoadCardsImpl(
        private val cardsRepository: CardsRepository,
        private val locationPreferences: LocationPreferences
) : LoadCards {


    override fun invoke(): Single<List<CardItemUIModel>> =
            locationPreferences.getCurrentLocation()
                    .flatMap { cardsRepository.loadCards() }

}