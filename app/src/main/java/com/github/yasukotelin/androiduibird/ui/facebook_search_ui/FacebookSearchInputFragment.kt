package com.github.yasukotelin.androiduibird.ui.facebook_search_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionSet
import com.github.yasukotelin.androiduibird.databinding.FragmentFacebookSearchInputBinding

class FacebookSearchInputFragment : Fragment() {

    companion object {
        fun newInstance() = FacebookSearchInputFragment()
    }

    private val facebookSearchInputViewModel: FacebookSearchInputViewModel by viewModels()

    private lateinit var dataBinding: FragmentFacebookSearchInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        SharedElement Transition設定
         */
        val transition = TransitionSet().apply {
            addTransition(ChangeBounds())
            addTransition(ChangeTransform())
            addTransition(ChangeImageTransform())
        }.setDuration(200)
        sharedElementEnterTransition = transition
        sharedElementReturnTransition = transition
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentFacebookSearchInputBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.viewModel = facebookSearchInputViewModel
        }

        observeFacebookSearchInputViewModel()

        return dataBinding.root
    }

    private fun observeFacebookSearchInputViewModel() {
        facebookSearchInputViewModel.run {
            this.navigatePopBackAction.observe(viewLifecycleOwner, {
                findNavController().popBackStack()
            })
        }
    }
}