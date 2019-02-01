package com.loyalty.customer.presentation.cards

import com.loyalty.core.util.extensions.observeOnUi
import com.loyalty.customer.ui.models.card.CardItemUIModel
import com.loyalty.customer.usecases.cards.LoadCards
import com.loyalty.customer.util.extensions.deepCopy
import timber.log.Timber

class CardsViewModelImpl(
        private val loadCards: LoadCards
) : CardsViewModel() {

    override val initialState: CardsState get() = CardsState()

    private var cachedCards: List<CardItemUIModel> = emptyList()

    init {
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
        setState(currentState.copy(cards = cards, isLoading = false))
    }

    private fun onLoadCardsError(error: Throwable) {
        Timber.e(error)
        setState(currentState.copy(isLoading = false, isError = true))
    }

    override fun selectCard(position: Int) {
        val newCards = cachedCards.deepCopy().toMutableList()
        val card = newCards[position]
        val newCard = card.copy(isExpandedState = !card.isExpandedState)

        newCards[position] = newCard
        cachedCards = newCards

        setState(currentState.copy(cards = cachedCards))
    }

}