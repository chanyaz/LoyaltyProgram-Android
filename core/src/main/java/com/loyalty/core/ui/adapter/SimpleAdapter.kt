package com.loyalty.core.ui.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

abstract class SimpleAdapter<T : SimpleRecyclerModel> : RecyclerView.Adapter<SimpleHolder<T>>() {

    protected var elements: List<T> = emptyList()

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(viewHolder: SimpleHolder<T>, position: Int) =
            viewHolder.bind(elements[position])

    fun setItems(items: List<T>) {
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallback(elements, items))

        elements = items
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffCallback<T : SimpleRecyclerModel>(
            private val oldList: List<T>,
            private val newList: List<T>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}

