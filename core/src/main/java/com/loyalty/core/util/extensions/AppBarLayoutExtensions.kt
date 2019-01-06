package com.loyalty.core.util.extensions

import android.support.design.widget.AppBarLayout

fun AppBarLayout.setOnCollapseListener(onCollapse: () -> Unit, onExpand: () -> Unit) {
    this.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
            onCollapse()
        } else {
            onExpand()
        }
    })
}