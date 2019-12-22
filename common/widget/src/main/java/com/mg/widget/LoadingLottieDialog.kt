package com.mg.widget

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.StyleRes


class LoadingLottieDialog private constructor(
    context: Context?,
    theme: Int,
    cancelable: Boolean,
    cancelListener: DialogInterface.OnCancelListener?
) : AlertDialog(context, theme) {


    class Builder {
        private var context: Context? = null
        private var themeId = 0
        private var cancelable = true
        private var cancelListener: DialogInterface.OnCancelListener? = null


        fun setContext(context: Context?): Builder {
            this.context = context
            return this
        }

        fun setTheme(@StyleRes themeId: Int): Builder {
            this.themeId = themeId
            return this
        }

        fun setCancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }

        fun setCancelListener(cancelListener: DialogInterface.OnCancelListener?): Builder {
            this.cancelListener = cancelListener
            return this
        }

        fun build(): AlertDialog {
            return LoadingLottieDialog(
                context,
                if (themeId != 0) themeId else R.style.LoadingDialogDefault,
                cancelable,
                cancelListener
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_loading_lottie)
        setCanceledOnTouchOutside(false)
    }
    init {
        setCancelable(cancelable)
        cancelListener?.let { setOnCancelListener(it) }
    }
}