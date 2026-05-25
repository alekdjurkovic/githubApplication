package com.example.github.domain.repository

import com.example.github.domain.model.DataResult
import com.example.github.domain.model.User

interface UserRepository {
    suspend fun getUser(login: String): DataResult<User>
}
