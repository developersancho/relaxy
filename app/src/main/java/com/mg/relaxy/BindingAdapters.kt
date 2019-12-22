package com.mg.relaxy

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mg.util.extensions.load

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("toImageUrl")
    fun showImage(view: ImageView, url: String? = null) {
        url?.let {
            view.load(url)
        } ?: run {
            view.load(R.drawable.ic_john_wick)
        }
    }

}