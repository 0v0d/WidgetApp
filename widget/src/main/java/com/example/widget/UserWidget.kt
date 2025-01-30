package com.example.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import com.example.widget.component.UserWidgetContent
import com.example.widget.extension.getUserRepository

class UserWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val repository = context.applicationContext.getUserRepository()
        val userImageURL = repository.getRandomUserImage()

        provideContent {
            GlanceTheme {
                UserWidgetContent(context, userImageURL)
            }
        }
    }
}







