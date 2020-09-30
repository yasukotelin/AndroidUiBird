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
                    R.raw.searchtextbox_sharedelement,
                    Destination.FacebookSearchUi,
                ),
                Content(
                    R.string.content_title_like_image_animation,
                    R.string.content_app_name_line_manga,
                    R.raw.like_image_animation,
                    Destination.LikeImageAnimation,
                )
            )
        )
    )
    val homeViewData: LiveData<HomeViewData>
        get() = _homeViewData

    private val _navigateFacebookSearchUiAction = LiveEvent<Unit>()
    val navigateFacebookSearchUiAction: LiveData<Unit>
        get() = _navigateFacebookSearchUiAction

    private val _navigateLikeImageAnimationAction = LiveEvent<Unit>()
    val navigateLikeImageAnimationAction: LiveData<Unit>
        get() = _navigateLikeImageAnimationAction

    override fun onClickContent(content: Content) {
        when (content.destination) {
            Destination.FacebookSearchUi -> _navigateFacebookSearchUiAction.postValue(Unit)
            Destination.LikeImageAnimation -> _navigateLikeImageAnimationAction.postValue(Unit)
        }
    }
}