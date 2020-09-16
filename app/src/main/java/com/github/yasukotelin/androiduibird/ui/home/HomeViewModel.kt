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
                    R.raw.facebook_search_ui_gif,
                    Destination.FacebookSearchUi,
                ),
                Content(
                    R.string.content_title_like_image_animation,
                    R.string.content_app_name_line_manga,
                    R.drawable.shape_loading_thumbnail,
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