package com.github.yasukotelin.androiduibird.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textFromResourceId")
fun TextView.bindTextFromResourceId(resId: Int) {
    this.text = this.context.getString(resId)
}