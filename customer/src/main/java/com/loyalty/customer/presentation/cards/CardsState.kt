package com.loyalty.customer.presentation.cards

import com.loyalty.core.presentation.base.BaseState
import com.loyalty.customer.ui.models.card.CardItemUIModel

data class CardsState(
        val cards: List<CardItemUIModel> = emptyList(),
        val isLoading: Boolean = true,
        val isError: Boolean = false
): BaseState()