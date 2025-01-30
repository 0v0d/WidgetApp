package com.example.widget.component

import androidx.compose.runtime.Composable
import androidx.glance.GlanceTheme
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import com.example.widget.R
import com.example.widget.util.Util.stringRes

@Composable
fun ErrorContent() {
    Text(
        text =  stringRes(R.string.error_loading_widget),
        style = TextStyle(
            color = GlanceTheme.colors.error,
            textAlign = TextAlign.Center
        )
    )
}