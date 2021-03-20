package com.munny.randomuserbusinesscard

import android.view.View
import androidx.databinding.BindingConversion

@BindingConversion
fun conversionBooleanToVisible(b: Boolean): Int {
    return if (b) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}