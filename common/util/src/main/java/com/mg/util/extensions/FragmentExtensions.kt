package com.mg.util.extensions

import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.andrognito.flashbar.Flashbar
import com.mg.util.R

fun FragmentActivity.showFlashBar(message: String) {
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .message(message)
        .messageColor(
            ContextCompat.getColor(
                this, android.R.color.black
            )
        )
        .duration(1500)
        .messageSizeInSp(16f)
        .vibrateOn(Flashbar.Vibration.SHOW)
        .build().show()
}