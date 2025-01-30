package com.example.widget.extension

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.toBitmapOrNull
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.core.UserRepository
import com.example.widget.di.UserWidgetEntryPoint
import dagger.hilt.android.EntryPointAccessors

suspend fun Context.getImage(url: String): Bitmap? {
    val request = ImageRequest.Builder(this)
        .data(url)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .build()

    return when (val result = imageLoader.execute(request)) {
        is ErrorResult -> throw result.throwable
        is SuccessResult -> result.drawable.toBitmapOrNull()
    }
}

fun Context.getUserRepository(): UserRepository {
    val hiltEntryPoint = EntryPointAccessors.fromApplication(
        applicationContext,
        UserWidgetEntryPoint::class.java
    )
    return hiltEntryPoint.userRepository()
}