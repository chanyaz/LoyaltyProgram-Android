package com.loyalty.customer.presentation.cards.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.CardItemUIModel

class CardsAdapter(
        private var elements: List<CardItemUIModel>,
        private val onCardClicked: (Int) -> Unit
) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(elements[position])

    override fun onViewAttachedToWindow(holder: CardViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            TODO()
        }
    }

    override fun onViewDetachedFromWindow(holder: CardViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun setItems(items: List<CardItemUIModel>) {
        elements = items
        notifyDataSetChanged() // todo use diff util AND create base adapter class with it
    }

}