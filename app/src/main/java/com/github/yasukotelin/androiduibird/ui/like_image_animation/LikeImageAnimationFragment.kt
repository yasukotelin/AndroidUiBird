package com.github.yasukotelin.androiduibird.ui.like_image_animation

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.yasukotelin.androiduibird.R
import com.github.yasukotelin.androiduibird.databinding.FragmentLikeImageAnimationBinding
import kotlinx.android.synthetic.main.fragment_like_image_animation.*
import kotlinx.android.synthetic.main.fragment_like_image_animation.view.*


class LikeImageAnimationFragment : Fragment() {

    companion object {
        fun newInstance() = LikeImageAnimationFragment()
    }

    private val likeImageAnimationViewModel by viewModels<LikeImageAnimationViewModel>()

    private lateinit var dataBinding: FragmentLikeImageAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentLikeImageAnimationBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.viewModel = likeImageAnimationViewModel
        }

        observeLikeImageAnimationViewModel()

        return dataBinding.root
    }

    private fun observeLikeImageAnimationViewModel() {
        likeImageAnimationViewModel.run {
            this.likeAction.observe(viewLifecycleOwner, {
                startAnimationLikeImageVisible()
            })
            this.likeVisibleInAnimationEndAction.observe(viewLifecycleOwner, {
                startAnimationLikeImageGone()
            })
        }
    }

    private fun startAnimationLikeImageVisible() {
        dataBinding.likeImageCard.run {
            this.alpha = 0f
            this.scaleX = 0f
            this.scaleY = 0f
            this.visibility = View.VISIBLE
            this.animate()
                .alpha(1f)
                .setDuration(300)
                .scaleX(1f)
                .scaleY(1f)
                .setInterpolator(OvershootInterpolator())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator?) {
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        likeImageAnimationViewModel.onLikeShowInAnimationEnd()
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                    }

                    override fun onAnimationRepeat(p0: Animator?) {
                    }
                })
        }
    }

    private fun startAnimationLikeImageGone() {
        // BottomNavigationのView取得
        val bottomFavoriteView = bottomNavigationView

        val view = dataBinding.likeImageCard
        view.animate()
            .setDuration(400)
            .scaleY(0f)
            .scaleX(0f)
            .translationY(bottomFavoriteView.y)
            .setInterpolator(AccelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                }

                override fun onAnimationEnd(p0: Animator?) {
                    view.visibility = View.GONE
                    // 座標を元の位置に戻す
                    view.translationX = 0f
                    view.translationY = 0f
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }
            })
    }
}