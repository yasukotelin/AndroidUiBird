package com.github.yasukotelin.androiduibird.ui.home

import com.airbnb.epoxy.TypedEpoxyController
import com.github.yasukotelin.androiduibird.homeUiGridList

interface HomeControllerListener {
    fun onClickContent(content: Content)
}

class HomeController(
    private val listener: HomeControllerListener,
) : TypedEpoxyController<HomeViewData>() {

    override fun buildModels(homeViewData: HomeViewData?) {
        homeViewData ?: return

        homeViewData.contents.forEach {
            homeUiGridList {
                id(modelCountBuiltSoFar)
                content(it)
                onClick { model, _, _, _ ->
                    listener.onClickContent(model.content())
                }
            }
        }
    }
}