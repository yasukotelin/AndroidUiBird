package com.github.yasukotelin.androiduibird.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yasukotelin.androiduibird.R

data class Content(val titleResId: Int, val appNameResId: Int, val thumbnailResId: Int)

class HomeViewModel : ViewModel() {

    private val _contents = MutableLiveData(
        listOf(
            Content(
                R.string.content_title_facebook_search_ui,
                R.string.content_app_name_facebook,
                R.drawable.shape_loading_thumbnail
            )
        )
    )
    val contents: LiveData<List<Content>>
        get() = _contents

}