package com.example.widget.di

import com.example.core.UserRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface UserWidgetEntryPoint {
    fun userRepository(): UserRepository
}