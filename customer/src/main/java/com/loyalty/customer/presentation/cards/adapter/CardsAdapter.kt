package com.loyalty.customer.presentation.cards.adapter

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.card.CardItemUIModel

class CardsAdapter(
        private val onCardClicked: (Int) -> Unit
) : SimpleAdapter<CardItemUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, @LayoutRes viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int =
            if (elements[position].isExpandedState) R.layout.card_item_expanded else R.layout.card_item

    override fun onViewAttachedToWindow(holder: SimpleHolder<CardItemUIModel>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            onCardClicked(holder.adapterPosition)
        }
    }

    override fun onViewDetachedFromWindow(holder: SimpleHolder<CardItemUIModel>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

}