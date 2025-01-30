package com.example.widget.component

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.CircularProgressIndicator
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.ContentScale
import androidx.glance.layout.fillMaxSize
import com.example.widget.R
import com.example.widget.extension.getImage
import com.example.widget.util.Util.stringRes

@Composable
fun UserWidgetContent(
    context: Context,
    userImageURL: String
) {
    var userImage by remember(userImageURL) { mutableStateOf<Bitmap?>(null) }
    var hasError by remember { mutableStateOf(false) }

    LaunchedEffect(userImageURL) {
        runCatching {
            userImage = context.getImage(userImageURL)
        }.onFailure { _ ->
            hasError = true
        }
    }

    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(GlanceTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        if (hasError) {
            ErrorContent()
        } else {
            userImage?.let { image ->
                Image(
                    provider = ImageProvider(image),
                    contentDescription = stringRes(R.string.user_image_description),
                    contentScale = ContentScale.Fit,
                    modifier = GlanceModifier.fillMaxSize()
                )
            } ?: CircularProgressIndicator()
        }
    }
}