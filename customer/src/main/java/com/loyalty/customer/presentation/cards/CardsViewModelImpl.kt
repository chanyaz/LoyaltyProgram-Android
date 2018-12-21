package com.loyalty.customer.presentation.cards

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.CardItemUIModel
import com.loyalty.customer.usecases.cards.LoadCards
import timber.log.Timber

class CardsViewModelImpl(
        private val loadCards: LoadCards
) : CardsViewModel() {

    private var cachedCards: List<CardItemUIModel> = emptyList()

    init {
        setState(CardsState())
        loadData()
    }

    private fun loadData() {
        subscribe(loadCards()
                .observeOnUi()
                .subscribe(::onLoadCardsSuccess, ::onLoadCardsError)
        )
    }

    private fun onLoadCardsSuccess(cards: List<CardItemUIModel>) {
        cachedCards = cards
        setState(currentState.copy(cards = cards, isLoading = false, isError = false))
    }

    private fun onLoadCardsError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

    override fun selectCard(position: Int) {
//        cachedCards[position].isExpandedState.flip
    }

}