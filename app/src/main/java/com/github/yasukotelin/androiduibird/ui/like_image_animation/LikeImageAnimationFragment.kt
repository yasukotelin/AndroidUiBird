package com.github.yasukotelin.androiduibird.ui.like_image_animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.yasukotelin.androiduibird.R

class LikeImageAnimationFragment : Fragment() {

    companion object {
        fun newInstance() = LikeImageAnimationFragment()
    }

    private val likeImageAnimationViewModel by viewModels<LikeImageAnimationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_like_image_animation, container, false)
    }
}