package com.mg.util.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.mg.util.R

fun ImageView.load(@DrawableRes resourceId: Int) {
    Glide.with(context).load(resourceId).placeholder(R.drawable.ic_john_wick)
        .into(this)
}

fun ImageView.load(url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.ic_john_wick)
        .into(this)
}