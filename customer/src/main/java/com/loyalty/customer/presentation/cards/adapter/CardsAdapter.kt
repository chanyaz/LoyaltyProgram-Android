package com.loyalty.customer.presentation.cards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.core.ui.adapter.SimpleAdapter
import com.loyalty.core.ui.adapter.SimpleHolder
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.CardItemUIModel

class CardsAdapter(
        private val onCardClicked: (Int) -> Unit
) : SimpleAdapter<CardItemUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onViewAttachedToWindow(holder: SimpleHolder<CardItemUIModel>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            /* TODO */
        }
    }

    override fun onViewDetachedFromWindow(holder: SimpleHolder<CardItemUIModel>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

}