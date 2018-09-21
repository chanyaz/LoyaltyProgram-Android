package com.loyalty.core.extensions

import android.content.SharedPreferences

fun SharedPreferences.editAndApply(block: SharedPreferences.Editor.() -> Unit) {
    val editor = this.edit()
    editor.block()
    editor.apply()
}