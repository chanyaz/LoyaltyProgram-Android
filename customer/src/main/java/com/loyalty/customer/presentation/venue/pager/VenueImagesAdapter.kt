package com.loyalty.customer.presentation.venue.pager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.loyalty.customer.R
import com.loyalty.customer.ui.models.venue.VenueImageUIModel
import kotlinx.android.synthetic.main.venue_image_item.view.venueImageItem

class VenueImagesAdapter(context: Context?) : PagerAdapter() {

    var images: List<VenueImageUIModel> = emptyList()

    private val inflater = LayoutInflater.from(context)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = inflater.inflate(R.layout.venue_image_item, container, false)
        Glide.with(view).load(images[position].venueImage).into(view.venueImageItem)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as FrameLayout)
    }

    override fun getCount(): Int = images.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = (view == obj)

    override fun getItemPosition(obj: Any): Int = POSITION_NONE

}