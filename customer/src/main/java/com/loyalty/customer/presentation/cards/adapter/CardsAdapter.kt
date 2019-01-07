package com.loyalty.customer.presentation.cards.adapter

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.loyalty.core.ui.adapter.SimpleDelegationAdapter
import com.loyalty.customer.presentation.cards.adapter.delegates.CollapsedCardsDelegate
import com.loyalty.customer.presentation.cards.adapter.delegates.ExpandedCardsDelegate
import com.loyalty.customer.ui.models.card.CardItemUIModel

class CardsAdapter(
        private val onCardClicked: (Int) -> Unit
) : SimpleDelegationAdapter<CardItemUIModel>(
        AdapterDelegatesManager<List<CardItemUIModel>>().apply {
            addDelegate(CollapsedCardsDelegate(onCardClicked))
            addDelegate(ExpandedCardsDelegate(onCardClicked))
        }
)