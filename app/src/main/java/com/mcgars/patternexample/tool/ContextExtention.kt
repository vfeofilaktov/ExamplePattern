package com.mcgars.patternexample.tool

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * hide keyboard and clear focus for given view
 *
 * @param view view for which we need to hide keyboard
 */
fun View?.hideKeyboard() {
    this?.let {
        it.clearFocus()
        val imm = it.getInputMethodManager()
        imm?.hideSoftInputFromWindow(it.windowToken, 0)
    }
}


private fun View?.getInputMethodManager(): InputMethodManager? {
    return this?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
}