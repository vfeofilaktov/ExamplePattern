package com.mcgars.patternexample.feature.search_result

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcgars.patternexample.R
import com.mcgars.patternexample.search.SearchComposite
import kotlinx.android.synthetic.main.fragment_search_result.view.*


class SearchResultFragment : Fragment() {

    companion object {
        fun newInstance(params: SearchComposite): SearchResultFragment {
            return SearchResultFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("filter", params)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.fragment_search_form_button_search.setOnClickListener {
            fragmentManager.popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val filter = arguments.getSerializable("filter") as SearchComposite

        val uriBuilder = Uri.Builder().scheme("http").path("test.com")
        // дополняем к ссылке параметры
        filter.append(uriBuilder)
        // выводим получившуюся ссылку в TextView
        view?.fragment_search_form_text_view_result?.text = uriBuilder.build().toString()
        // для пользователя информация поиска в простой форме
        view?.fragment_search_form_text_view_params?.text = filter.toString(activity)
    }

}