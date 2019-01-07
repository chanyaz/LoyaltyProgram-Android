package com.loyalty.customer.presentation.cards.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleDelegate
import com.loyalty.customer.R
import com.loyalty.customer.presentation.cards.adapter.holders.CardViewHolder
import com.loyalty.customer.ui.models.card.CardItemUIModel

class ExpandedCardsDelegate(
        private val onCardClicked: (Int) -> Unit
) : SimpleDelegate<CardItemUIModel, CardItemUIModel, CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): CardViewHolder =
            CardViewHolder(createView(parent, R.layout.card_item_expanded))

    override fun isForViewType(item: CardItemUIModel, items: MutableList<CardItemUIModel>, position: Int): Boolean =
            item.isExpandedState

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as CardViewHolder).itemView.setOnClickListener {
            onCardClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as CardViewHolder).itemView.setOnClickListener(null)
    }

}