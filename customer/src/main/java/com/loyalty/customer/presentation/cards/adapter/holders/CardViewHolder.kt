package com.loyalty.customer.presentation.cards.adapter.holders

import android.annotation.SuppressLint
import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleDelegationHolder
import com.loyalty.customer.ui.models.card.CardItemUIModel
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardDate
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardDaysLeft
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardLogo
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardNumberOfStamps
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardNumberOutOf
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardVenueName
import kotlinx.android.synthetic.main.card_item_collapsed.view.cardVenueType
import kotlinx.android.synthetic.main.card_item_expanded.view.cardTypeView

class CardViewHolder(itemView: View) : SimpleDelegationHolder<CardItemUIModel>(itemView) {

    private val cardVenueName = itemView.cardVenueName
    private val cardVenueType = itemView.cardVenueType
    private val cardDaysLeft = itemView.cardDaysLeft
    private val cardDate = itemView.cardDate
    private val cardNumberOfStamps = itemView.cardNumberOfStamps
    private val cardNumberOutOf = itemView.cardNumberOutOf
    private val cardLogo = itemView.cardLogo
    private val cardTypeView = itemView.cardTypeView

    @SuppressLint("SetTextI18n")
    override fun bind(model: CardItemUIModel) {
        with(model) {
            cardVenueName.text = venueName
            cardVenueType.text = venueType
            cardDaysLeft.text = daysLeft.toString()
            cardDate.text = eventDate
            cardNumberOfStamps.text = currentStamps.toString()
            cardNumberOutOf.text = "/$outOfStamps"
            Glide.with(itemView).load(imageUrl).into(cardLogo)

            if (isExpandedState) {
                /* todo */
            }
        }
    }

}