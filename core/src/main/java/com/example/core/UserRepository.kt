package com.example.core

import kotlin.random.Random

interface UserRepository {
    suspend fun getRandomUserImage(): String
}

class UserRepositoryImpl : UserRepository {
    private var i = Random.nextInt(1, 99)
    override suspend fun getRandomUserImage(): String {
        return "https://randomuser.me/api/portraits/men/$i.jpg"
    }
}
