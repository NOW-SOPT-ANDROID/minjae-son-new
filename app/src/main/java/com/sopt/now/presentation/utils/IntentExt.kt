package com.sopt.now.presentation.utils

import android.content.Intent
import android.os.Build

fun <T> Intent.getSafeParcelable(name: String, clazz: Class<T>): T? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(name, clazz)
    } else {
        getParcelableExtra(name)
    }