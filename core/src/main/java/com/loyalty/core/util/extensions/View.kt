package com.loyalty.core.util.extensions

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

/* *
 * Extensions for groups of views are a workaround as
 * currently constraint layout groups do not properly work
 * */

fun List<View>.gone() {
    this.forEach { it.gone() }
}

fun List<View>.visible() {
    this.forEach { it.visible() }
}

fun List<View>.invisible() {
    this.forEach { it.invisible() }
}