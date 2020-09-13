package com.github.yasukotelin.androiduibird.ui.facebook_search_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.androiduibird.databinding.FragmentFacebookUiSearchBinding

class FacebookUiSearchFragment : Fragment() {

    companion object {
        fun newInstance() = FacebookUiSearchFragment()
    }

    private val facebookUiSearchViewModel: FacebookUiSearchViewModel by viewModels()

    private lateinit var dataBinding: FragmentFacebookUiSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentFacebookUiSearchBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.viewModel = facebookUiSearchViewModel
        }

        observeFacebookUiSearchViewModel()

        return dataBinding.root
    }

    private fun observeFacebookUiSearchViewModel() {
        facebookUiSearchViewModel.run {
            this.navigateSearchInputAction.observe(viewLifecycleOwner, {
                findNavController().navigate(
                    FacebookUiSearchFragmentDirections.actionFacebookUiSearchFragmentToFacebookSearchInputFragment()
                )
            })
        }
    }
}