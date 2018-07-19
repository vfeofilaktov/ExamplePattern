package com.mcgars.patternexample.search

import android.content.Context
import android.net.Uri
import com.mcgars.patternexample.R


class SearchName(
        var name: String = ""
) : Search {

    override fun append(uri: Uri.Builder) {
        if (name.isNotBlank()) {
            uri.appendQueryParameter("name", name)
        }
    }

    override fun getTitle(): String = "Ключевые слова"

    override fun toString(context: Context): String {
        return when {
            name.isNotBlank() -> return context.getString(R.string.name, name)
            else -> ""
        }
    }

    override fun toString(): String = name.takeIf { it.isNotEmpty() } ?: ""

}