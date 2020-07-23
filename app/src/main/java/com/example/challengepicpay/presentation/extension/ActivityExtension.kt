package com.example.challengepicpay.presentation.extension

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes


fun Activity.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun ProgressBar.visibilityLoading(visibility: Boolean) {
    if (visibility) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}