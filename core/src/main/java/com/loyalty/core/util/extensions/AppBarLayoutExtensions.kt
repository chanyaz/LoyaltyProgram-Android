package com.loyalty.core.util.extensions

import android.support.design.widget.AppBarLayout
import com.loyalty.core.util.delegates.FieldProperty

fun AppBarLayout.setOnCollapseListener(onCollapse: () -> Unit, onExpand: () -> Unit) {
    this.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        if (previousVerticalOffset == verticalOffset)
            return@OnOffsetChangedListener

        previousVerticalOffset = verticalOffset
        if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
            onCollapse()
        } else {
            onExpand()
        }
    })
}

var AppBarLayout.previousVerticalOffset: Int by FieldProperty { -1 }