package com.github.yasukotelin.androiduibird.ui.facebook_search_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.yasukotelin.androiduibird.databinding.FragmentFacebookSearchInputBinding

class FacebookSearchInputFragment : Fragment() {

    companion object {
        fun newInstance() = FacebookSearchInputFragment()
    }

    private val viewModel: FacebookSearchInputViewModel by viewModels()

    private lateinit var dataBinding: FragmentFacebookSearchInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentFacebookSearchInputBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
        }
        return dataBinding.root
    }
}