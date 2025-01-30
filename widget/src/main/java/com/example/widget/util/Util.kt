package com.example.widget.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.glance.LocalContext

object Util{
    @Composable
    fun stringRes(@StringRes id: Int): String {
        return LocalContext.current.getString(id)
    }
}