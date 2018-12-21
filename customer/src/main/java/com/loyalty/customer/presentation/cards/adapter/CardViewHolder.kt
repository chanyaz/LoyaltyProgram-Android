package com.loyalty.customer.presentation.cards.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.customer.ui.models.CardItemUIModel
import kotlinx.android.synthetic.main.card_item.view.cardDate
import kotlinx.android.synthetic.main.card_item.view.cardDaysLeft
import kotlinx.android.synthetic.main.card_item.view.cardLogo
import kotlinx.android.synthetic.main.card_item.view.cardNumberOfStamps
import kotlinx.android.synthetic.main.card_item.view.cardNumberOutOf
import kotlinx.android.synthetic.main.card_item.view.cardVenueName
import kotlinx.android.synthetic.main.card_item.view.cardVenueType

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val cardVenueName = itemView.cardVenueName
    private val cardVenueType = itemView.cardVenueType
    private val cardDaysLeft = itemView.cardDaysLeft
    private val cardDate = itemView.cardDate
    private val cardNumberOfStamps = itemView.cardNumberOfStamps
    private val cardNumberOutOf = itemView.cardNumberOutOf
    private val cardLogo = itemView.cardLogo

    @SuppressLint("SetTextI18n")
    fun bind(model: CardItemUIModel) {
        with(model) {
            cardVenueName.text = venueName
            cardVenueType.text = venueType
            cardDaysLeft.text = daysLeft.toString()
            cardDate.text = eventDate
            cardNumberOfStamps.text = currentStamps.toString()
            cardNumberOutOf.text = "/$outOfStamps"
            Glide.with(itemView).load(imageUrl).into(cardLogo)
        }
    }

}