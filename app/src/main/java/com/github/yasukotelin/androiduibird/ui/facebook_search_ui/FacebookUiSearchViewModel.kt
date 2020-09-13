package com.github.yasukotelin.androiduibird.ui.facebook_search_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class FacebookUiSearchViewModel : ViewModel() {

    private val _navigateSearchInputAction = LiveEvent<Unit>()
    val navigateSearchInputAction: LiveData<Unit>
        get() = _navigateSearchInputAction

    fun onClickSearch() {
        _navigateSearchInputAction.postValue(Unit)
    }
}