package com.loyalty.core.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

@Deprecated("Use SimpleDelegationHolder")
abstract class SimpleHolder<T : SimpleRecyclerModel>(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: T)

}