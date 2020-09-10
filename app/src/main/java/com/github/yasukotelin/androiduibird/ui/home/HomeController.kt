package com.github.yasukotelin.androiduibird.ui.home

import com.airbnb.epoxy.EpoxyController
import com.github.yasukotelin.androiduibird.homeUiGridList

class HomeController : EpoxyController() {

    var contents: List<Content>? = null

    override fun buildModels() {
        contents?.let { contents ->
            contents.forEach {
                homeUiGridList {
                    id(modelCountBuiltSoFar)
                    content(it)
                }
            }
        }
    }
}