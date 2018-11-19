package com.loyalty.core.util.extensions

import android.text.Editable
import android.widget.EditText
import com.loyalty.core.ui.SimpleTextWatcher

fun EditText.setOnTextChangedListener(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : SimpleTextWatcher {
        override fun afterTextChanged(s: Editable) {
            onTextChanged.invoke(s.toString())
        }
    })
}