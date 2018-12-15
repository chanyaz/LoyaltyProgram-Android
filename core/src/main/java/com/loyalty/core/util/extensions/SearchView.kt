package com.loyalty.core.util.extensions

import android.support.v7.widget.SearchView

fun SearchView.setOnQueryChangedListener(onQueryTextChanged: (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            return true
        }

        override fun onQueryTextChange(query: String): Boolean {
            onQueryTextChanged(query)
            return true
        }
    })
}