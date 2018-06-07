package com.mcgars.patternexample.search

import android.content.Context
import android.net.Uri
import com.mcgars.patternexample.R


class SearchSex(
        var sex: String = ""
) : Search {

    override fun addToUrl(uri: Uri.Builder) {
        if (sex.isNotEmpty()) {
            uri.appendQueryParameter("sex", sex)
        }
    }

    override fun getTitle(): String = "Пол"

    override fun toString(context: Context): String {
        return when {
            sex.isNotBlank() -> return context.getString(R.string.sex, sex)
            else -> ""
        }
    }

    override fun toString(): String = sex

}