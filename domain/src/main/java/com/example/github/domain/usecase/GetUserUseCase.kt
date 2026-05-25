package com.example.github.domain.usecase

import com.example.github.domain.model.DataResult
import com.example.github.domain.model.User
import com.example.github.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(login: String): DataResult<User> = repository.getUser(login)
}
