package com.mcgars.patternexample.tool

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


inline fun EditText.addTextChange(crossinline action: (CharSequence)->Unit): TextWatcher {
    val textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable) {

        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            action.invoke(s)
        }

    }
    addTextChangedListener(textWatcher)
    return textWatcher
}