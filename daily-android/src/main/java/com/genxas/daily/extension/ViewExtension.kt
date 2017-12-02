package com.genxas.daily.extension

import android.view.View

fun View.click(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}
