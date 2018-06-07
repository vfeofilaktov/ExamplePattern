package com.mcgars.patternexample.repository

import android.content.Context
import com.google.gson.Gson
import com.mcgars.patternexample.search.SearchSex
import com.mcgars.patternexample.search.SearchContainer
import com.mcgars.patternexample.search.SearchName


class SearchStorage(context: Context) {

    private val pref = context.getSharedPreferences("SearchStorage", Context.MODE_PRIVATE)
    private val gson = Gson()

    private val itemsContainer = SearchContainer(
            SearchName(),
            SearchSex()
    )

    fun save() {
//        val edit = pref.edit()
//        itemsContainer.searchItems.forEach {
//            edit.putString(it.javaClass.simpleName, gson.toJson(it))
//        }
//        edit.apply()
    }

    fun restore(): SearchContainer? {

//        itemsContainer.searchItems.forEach {
//            pref.getString(it.javaClass.simpleName, null)?.let {
//                val searchPart = gson.fromJson(it, it.javaClass)
//
//            }
//        }

//        return itemsContainer
        return null
    }
}