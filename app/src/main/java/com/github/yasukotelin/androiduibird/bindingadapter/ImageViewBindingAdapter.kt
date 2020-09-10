package com.github.yasukotelin.androiduibird.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("load")
fun ImageView.bindLoad(resId: Int) {
    Glide.with(this).load(resId).into(this)
}