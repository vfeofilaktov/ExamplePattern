package com.mcgars.patternexample.feature.search_form.adapter

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate
import com.mcgars.patternexample.R
import com.mcgars.patternexample.search.Search
import com.mcgars.patternexample.search.SearchSex
import kotlinx.android.synthetic.main.item_search_age.view.*


class SexDelegate : AbsListItemAdapterDelegate<SearchSex, Search, RecyclerView.ViewHolder>() {

    override fun isForViewType(item: Search, items: MutableList<Search>, position: Int): Boolean {
        return item is SearchSex
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_search_age, parent, false)
        ) {
        }
    }

    override fun onBindViewHolder(item: SearchSex, viewHolder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        with(viewHolder.itemView) {
            item_search_age_text_view_title.text = item.getTitle()
            item_search_age_text_view_value.text = item.sex.takeIf { it.isNotEmpty() } ?: context.getString(R.string.tap_to_select)
            setOnClickListener { showDialogForSetAge(context, item_search_age_text_view_value, item) }
        }
    }

    private fun showDialogForSetAge(context: Context, textView: TextView, item: SearchSex) {
        val items = arrayOf("male", "female")
        AlertDialog.Builder(context)
                .setItems(items) { _, which ->
                    item.sex = items[which]
                    textView.text = item.sex
                }
                .show()
    }
}