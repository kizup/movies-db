package com.example.moviesdb.utils

import android.view.View
import android.view.View.*

fun View?.visibleOrGone(visible: Boolean) {
    if (this == null) {
        return
    }
    this.visibility = if (visible) {
        VISIBLE
    } else {
        GONE
    }
}

fun View?.visible() = this?.visibleOrGone(true)
fun View?.gone() = this?.visibleOrGone(false)

fun View?.invisible() {
    if (this == null) {
        return
    }
    visibility = INVISIBLE
}