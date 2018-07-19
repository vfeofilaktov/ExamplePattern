package com.mcgars.patternexample.search

import android.content.Context
import android.net.Uri


class SearchComposite(
        vararg searchItems: Search
) : Search {

    private val items = LinkedHashMap<String, Search>().also { map ->
        searchItems.forEach {
            map[it.javaClass.simpleName] = it
        }
    }

    override fun append(uri: Uri.Builder) {
        items.forEach { it.value.append(uri) }
    }

    override fun getTitle(): String = "Поиск"

    override fun toString(): String {
        return items
                .toList()
                .map { it.second.toString() }
                .joinToString { it }
    }

    override fun toString(context: Context): String {
        return items
                .toList()
                .mapNotNull { it.second.toString(context).takeIf { it.isNotEmpty() } }
                .joinToString { it }
    }

    fun getItems(): List<Search> = items.mapTo(mutableListOf()) { it.value }

}