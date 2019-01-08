package com.loyalty.customer.presentation.cards.adapter.holders

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.view.View
import com.bumptech.glide.Glide
import com.loyalty.core.ui.adapter.SimpleDelegationHolder
import com.loyalty.customer.R
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

            val quantityColor = ContextCompat.getColor(
                    cardNumberOfStamps.context,
                    if (currentStamps >= outOfStamps) R.color.cards_points_exceed_color else R.color.cards_points_color
            )

            cardNumberOfStamps.setTextColor(quantityColor)
            cardNumberOutOf.setTextColor(quantityColor)

            Glide.with(itemView).load(imageUrl).into(cardLogo)

            if (isExpandedState) {
                val filledPercentage = currentStamps / outOfStamps.toDouble()

                when {
                    filledPercentage == 0.0 -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_0)
                    filledPercentage < 0.3 -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_20)
                    filledPercentage < 0.5 -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_40)
                    filledPercentage < 0.7 -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_60)
                    filledPercentage < 0.9 -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_80)
                    else -> cardTypeView.setImageResource(R.drawable.img_coffe_cap_100)
                }
            }
        }
    }

}