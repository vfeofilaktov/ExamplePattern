package com.mcgars.patternexample.feature.search_form.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.mcgars.patternexample.R
import com.mcgars.patternexample.search.Search
import com.mcgars.patternexample.search.SearchName
import com.mcgars.patternexample.tool.addTextChange
import kotlinx.android.synthetic.main.item_search_name.view.*


class NameDelegate : AbsListItemAdapterDelegate<SearchName, Search, RecyclerView.ViewHolder>() {

    private var textWatcher: TextWatcher? = null

    override fun isForViewType(item: Search, items: MutableList<Search>, position: Int): Boolean {
        return item is SearchName
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_search_name, parent, false)
        ) {
        }
    }

    override fun onBindViewHolder(item: SearchName, viewHolder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val editText = viewHolder.itemView.item_search_name_edit_text_name
        editText.setText(item.name)
        editText.removeTextChangedListener(textWatcher)
        textWatcher = editText.addTextChange { item.name = it.toString() }
    }
}