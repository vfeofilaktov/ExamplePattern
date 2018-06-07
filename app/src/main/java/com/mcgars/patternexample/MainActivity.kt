package com.mcgars.patternexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mcgars.patternexample.feature.search_form.SearchFormFragment
import com.mcgars.patternexample.feature.search_result.SearchResultFragment
import com.mcgars.patternexample.search.SearchContainer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMainPage()
    }

    private fun loadMainPage() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main_container_root, SearchFormFragment())
                .commitAllowingStateLoss()
    }

    fun loadSearchResultPage(params: SearchContainer) {
        supportFragmentManager.beginTransaction()
                .add(R.id.activity_main_container_root, SearchResultFragment.newInstance(params))
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}
