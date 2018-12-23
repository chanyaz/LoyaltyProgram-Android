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
import com.loyalty.customer.ui.models.CardItemUIModel
import kotlinx.android.synthetic.main.cards_fragment.cardsEmpty
import kotlinx.android.synthetic.main.cards_fragment.cardsProgressBar
import kotlinx.android.synthetic.main.cards_fragment.cardsRecycler
import org.koin.android.viewmodel.ext.android.viewModel

class CardsFragment : MvvmFragment<CardsState, BaseEvent>() {

    override val layout: Int get() = R.layout.cards_fragment

    override val viewModel: CardsViewModel by viewModel()

    private lateinit var cardsAdapter: CardsAdapter

    override fun processState(state: CardsState) {
        super.processState(state)
        if (state.isLoading) {
            processLoadingState()
        } else if (state.isError) {
            processErrorState()
        } else if (!state.isLoading && !state.isError && state.cards.isEmpty()) {
            processEmptyState()
        } else if (!state.isLoading && !state.isError) {
            processLoadedState(state.cards)
        } else {
            throw UnexpectedStateException(state.toString())
        }
    }

    private fun processLoadingState() {
        cardsRecycler.invisible()
        cardsEmpty.invisible()
        cardsProgressBar.visible()
    }

    private fun processErrorState() {
        TODO()
    }

    private fun processEmptyState() {
        cardsRecycler.invisible()
        cardsEmpty.visible()
        cardsProgressBar.gone()
    }

    private fun processLoadedState(cards: List<CardItemUIModel>) {
        cardsRecycler.visible()
        cardsEmpty.invisible()
        cardsProgressBar.gone()

        if (!::cardsAdapter.isInitialized) {
            initCardsAdapter(cards)
        }
        cardsAdapter.setItems(cards)
    }

    private fun initCardsAdapter(cards: List<CardItemUIModel>) { // todo refactor this
        cardsAdapter = CardsAdapter(cards) { viewModel.selectCard(it) }
        cardsRecycler.apply {
            adapter = cardsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        fun newInstance(): CardsFragment = CardsFragment()
    }

}