package com.github.yasukotelin.androiduibird.ui.home

data class HomeViewData(
    val contents: List<Content>
)

data class Content(
    val titleResId: Int,
    val appNameResId: Int,
    val thumbnailResId: Int,
    val destination: Destination
)

enum class Destination {
    FacebookSearchUi,
    LikeImageAnimation,
}