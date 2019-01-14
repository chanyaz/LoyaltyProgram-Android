package com.loyalty.customer.presentation.cards

import android.support.v7.widget.LinearLayoutManager
import com.loyalty.core.exceptions.UnexpectedStateException
import com.loyalty.core.presentation.base.BaseEvent
import com.loyalty.core.presentation.mvvm.MvvmFragment
import com.loyalty.core.util.extensions.gone
import com.loyalty.core.util.extensions.invisible
import com.loyalty.core.util.extensions.visible
import com.loyalty.customer.R
import com.loyalty.customer.presentation.cards.adapter.CardsAdapter
import com.loyalty.customer.ui.models.card.CardItemUIModel
import kotlinx.android.synthetic.main.cards_fragment.cardsEmpty
import kotlinx.android.synthetic.main.cards_fragment.cardsProgressBar
import kotlinx.android.synthetic.main.cards_fragment.cardsRecycler
import kotlinx.android.synthetic.main.cards_fragment.toolbarSubtitle
import org.koin.android.viewmodel.ext.android.viewModel

class CardsFragment : MvvmFragment<CardsState, BaseEvent>() {

    override val layout: Int get() = R.layout.cards_fragment

    override val viewModel: CardsViewModel by viewModel()

    private lateinit var cardsAdapter: CardsAdapter

    override fun renderState(state: CardsState) {
        super.renderState(state)
        if (state.isLoading) {
            renderLoadingState()
        } else if (state.isError) {
            renderErrorState()
        } else if (!state.isLoading && !state.isError && state.cards.isEmpty()) {
            renderEmptyState()
        } else if (!state.isLoading && !state.isError) {
            renderLoadedState(state.cards)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun renderLoadingState() {
        cardsRecycler.invisible()
        cardsEmpty.invisible()
        cardsProgressBar.visible()
    }

    private fun renderErrorState() {
        TODO()
    }

    private fun renderEmptyState() {
        cardsRecycler.invisible()
        cardsEmpty.visible()
        cardsProgressBar.gone()
    }

    private fun renderLoadedState(cards: List<CardItemUIModel>) {
        cardsRecycler.visible()
        cardsEmpty.invisible()
        cardsProgressBar.gone()

        toolbarSubtitle.text = resources.getQuantityString(R.plurals.cards_plurals, cards.size, cards.size)

        if (!::cardsAdapter.isInitialized)
            initCardsAdapter()

        cardsAdapter.items = cards
    }

    private fun initCardsAdapter() {
        cardsAdapter = CardsAdapter { viewModel.selectCard(it) }
        cardsRecycler.apply {
            adapter = cardsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        fun newInstance(): CardsFragment = CardsFragment()
    }

}