package com.github.yasukotelin.androiduibird.ui.facebook_search_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

class FacebookSearchInputViewModel : ViewModel() {

    private val _navigatePopBackAction = LiveEvent<Unit>()
    val navigatePopBackAction: LiveData<Unit>
        get() = _navigatePopBackAction

    fun onClickCancel() {
        _navigatePopBackAction.postValue(Unit)
    }
}