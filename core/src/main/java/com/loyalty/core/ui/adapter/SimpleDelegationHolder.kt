package com.loyalty.core.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class SimpleDelegationHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: T)

}