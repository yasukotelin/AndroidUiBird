package com.github.yasukotelin.androiduibird.ui.like_image_animation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LikeImageAnimationViewModel : ViewModel() {
    private val _likeAction = LiveEvent<Unit>()
    val likeAction: LiveData<Unit>
        get() = _likeAction

    private val _likeVisibleAnimationEndAction = LiveEvent<Unit>()
    val likeVisibleInAnimationEndAction: LiveData<Unit>
        get() = _likeVisibleAnimationEndAction


    fun onClickLike() {
        _likeAction.postValue(Unit)
    }

    fun onLikeShowInAnimationEnd() = viewModelScope.launch {
        delay(500) // Like画像をユーザーに見せる時間
        _likeVisibleAnimationEndAction.postValue(Unit)
    }
}