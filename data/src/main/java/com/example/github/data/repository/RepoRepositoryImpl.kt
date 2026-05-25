package com.example.github.data.repository

import com.example.github.data.api.GitHubApiService
import com.example.github.data.mapper.toDomain
import com.example.github.data.result.safeApiCall
import com.example.github.data.result.toDataResult
import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag
import com.example.github.domain.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val api: GitHubApiService,
) : RepoRepository {

    override suspend fun getUserRepos(login: String): DataResult<List<Repo>> =
        safeApiCall { api.getUserRepos(login).map { it.toDomain() } }.toDataResult()

    override suspend fun getRepo(login: String, repoName: String): DataResult<Repo> =
        safeApiCall { api.getRepo(login, repoName).toDomain() }.toDataResult()

    override suspend fun getRepoTags(login: String, repoName: String): DataResult<List<Tag>> =
        safeApiCall { api.getRepoTags(login, repoName).map { it.toDomain() } }.toDataResult()
}
