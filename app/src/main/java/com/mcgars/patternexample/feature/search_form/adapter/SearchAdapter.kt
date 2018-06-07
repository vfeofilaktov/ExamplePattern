package com.mcgars.patternexample.feature.search_form.adapter

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.mcgars.patternexample.search.Search


class SearchAdapter(
        searchItems: List<Search>
) : ListDelegationAdapter<List<Search>>() {
    init {
        delegatesManager
                .addDelegate(NameDelegate())
                .addDelegate(AgeDelegate())

        setItems(searchItems)
    }
}