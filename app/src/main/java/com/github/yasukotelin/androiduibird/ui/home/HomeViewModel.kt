package com.github.yasukotelin.androiduibird.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yasukotelin.androiduibird.R
import com.hadilq.liveevent.LiveEvent

class HomeViewModel : ViewModel(), HomeControllerListener {

    private val _homeViewData = MutableLiveData(
        HomeViewData(
            listOf(
                Content(
                    R.string.content_title_facebook_search_ui,
                    R.string.content_app_name_facebook,
                    R.drawable.shape_loading_thumbnail,
                    Destination.FacebookSearchUi,
                )
            )
        )
    )
    val homeViewData: LiveData<HomeViewData>
        get() = _homeViewData

    private val _navigateFacebookSearchUiAction = LiveEvent<Unit>()
    val navigateFacebookSearchUiAction: LiveData<Unit>
        get() = _navigateFacebookSearchUiAction

    override fun onClickContent(content: Content) {
        when (content.destination) {
            Destination.FacebookSearchUi -> _navigateFacebookSearchUiAction.postValue(Unit)
        }
    }
}