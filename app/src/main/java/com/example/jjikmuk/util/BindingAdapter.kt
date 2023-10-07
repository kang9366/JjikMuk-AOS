package com.example.jjikmuk.util

import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("layoutMarginBottom")
    @JvmStatic
    fun setLayoutMarginBottom(view: View, dimen: Float) {
        (view.layoutParams as ViewGroup.MarginLayoutParams).let {
            it.bottomMargin = dimen.toInt()
            view.layoutParams = it
        }
    }
}

