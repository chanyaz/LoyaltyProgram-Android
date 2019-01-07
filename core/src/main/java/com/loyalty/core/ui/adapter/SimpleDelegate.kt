package com.loyalty.core.ui.adapter

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate

abstract class SimpleDelegate<I : T, T, VH : SimpleDelegationHolder<I>> : AbsListItemAdapterDelegate<I, T, VH>() {

    override fun onBindViewHolder(item: I, holder: VH, payloads: MutableList<Any>) =
        holder.bind(item)

    protected fun createView(parent: ViewGroup, @LayoutRes layout: Int): View =
        LayoutInflater.from(parent.context).inflate(layout, parent, false)

}