package com.loyalty.core.ui.adapter

import android.support.v7.util.DiffUtil
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

abstract class SimpleDelegationAdapter<T : SimpleRecyclerModel>(delegatesManager: AdapterDelegatesManager<List<T>>) : ListDelegationAdapter<List<T>>(delegatesManager) {

    init {
        super.setItems(emptyList())
    }

    override fun setItems(newItems: List<T>) {
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(SimpleDelegationAdapter.DiffCallback(items, newItems))
        items = newItems

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