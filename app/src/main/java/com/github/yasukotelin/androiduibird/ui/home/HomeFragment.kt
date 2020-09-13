package com.github.yasukotelin.androiduibird.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.github.yasukotelin.androiduibird.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var dataBinding: FragmentHomeBinding

    private val homeController: HomeController by lazy {
        HomeController(homeViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.epoxyRecyclerView.apply {
                this.layoutManager = GridLayoutManager(requireContext(), 2)
                this.setController(homeController)
            }
        }

        observeHomeViewModel()

        return dataBinding.root
    }

    private fun observeHomeViewModel() {
        homeViewModel.run {
            this.homeViewData.observe(viewLifecycleOwner, {
                homeController.setData(it)
            })
            this.navigateFacebookSearchUiAction.observe(viewLifecycleOwner, {
                findNavController().navigate(
                    HomeFragmentDirections.actionMainFragmentToFacebookUiSearchFragment()
                )
            })
        }
    }
}