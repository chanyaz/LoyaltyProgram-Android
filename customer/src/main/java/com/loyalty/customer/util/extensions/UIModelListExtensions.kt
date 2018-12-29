package com.loyalty.customer.util.extensions

import com.loyalty.customer.ui.models.CardItemUIModel

fun List<CardItemUIModel>.deepCopy() =
        this.map { it.copy() }