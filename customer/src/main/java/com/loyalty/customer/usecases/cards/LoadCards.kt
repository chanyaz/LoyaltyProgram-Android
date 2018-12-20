package com.loyalty.customer.usecases.cards

import com.loyalty.customer.ui.models.CardItemUIModel
import io.reactivex.Single

interface LoadCards {

    operator fun invoke(): Single<List<CardItemUIModel>>

}