package com.loyalty.customer.presentation.venue.adapter.options

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.VenueOptionUIModel

class VenueOptionsAdapter : RecyclerView.Adapter<VenueOptionHolder>() {

    private var options: List<VenueOptionUIModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): VenueOptionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.venue_option_item, parent, false)
        return VenueOptionHolder(view)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: VenueOptionHolder, position: Int) =
        holder.bind(options[position])

    override fun onViewAttachedToWindow(holder: VenueOptionHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener { view ->
            options[holder.adapterPosition].intent?.let {
                holder.itemView.context.startActivity(it)
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: VenueOptionHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun setItems(items: List<VenueOptionUIModel>) {
        options = items // todo use diff util
        notifyDataSetChanged()
    }

}