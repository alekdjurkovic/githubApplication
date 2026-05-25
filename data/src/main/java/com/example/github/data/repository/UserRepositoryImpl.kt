package com.example.github.data.repository

import com.example.github.data.api.GitHubApiService
import com.example.github.data.mapper.toDomain
import com.example.github.data.result.safeApiCall
import com.example.github.data.result.toDataResult
import com.example.github.domain.model.DataResult
import com.example.github.domain.model.User
import com.example.github.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GitHubApiService,
) : UserRepository {

    override suspend fun getUser(login: String): DataResult<User> =
        safeApiCall { api.getUser(login).toDomain() }.toDataResult()
}
