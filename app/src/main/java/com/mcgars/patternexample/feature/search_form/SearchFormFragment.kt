package com.mcgars.patternexample.feature.search_form

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.patternexample.MainActivity
import com.mcgars.patternexample.R
import com.mcgars.patternexample.feature.search_form.adapter.SearchAdapter
import com.mcgars.patternexample.search.SearchSex
import com.mcgars.patternexample.search.SearchContainer
import com.mcgars.patternexample.search.SearchName
import com.mcgars.patternexample.tool.hideKeyboard
import kotlinx.android.synthetic.main.fragment_search_form.view.*


class SearchFormFragment : Fragment() {

    private val itemsContainer = SearchContainer(
            SearchName(),
            SearchSex()
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.fragment_search_form_button_search.setOnClickListener {
            it.hideKeyboard()
            (activity as MainActivity).loadSearchResultPage(itemsContainer)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.fragment_search_form_recycler_search?.adapter = SearchAdapter(itemsContainer.getItems())
    }

}