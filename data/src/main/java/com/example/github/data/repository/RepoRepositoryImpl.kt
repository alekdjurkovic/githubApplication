package com.example.github.data.repository

import com.example.github.data.api.GitHubApiService
import com.example.github.data.mapper.toDomain
import com.example.github.data.api.safeApiCall
import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag
import com.example.github.domain.repository.RepoRepository
import javax.inject.Inject

internal class RepoRepositoryImpl @Inject constructor(
    private val api: GitHubApiService,
) : RepoRepository {

    companion object {
        private const val PAGE_SIZE = 100
    }

    override suspend fun getUserRepos(login: String): DataResult<List<Repo>> =
        safeApiCall {
            buildList {
                var page = 1
                do {
                    val batch = api.getUserRepos(login, page = page)
                    addAll(batch.map { it.toDomain() })
                    page++
                } while (batch.size == PAGE_SIZE)
            }
        }

    override suspend fun getRepo(login: String, repoName: String): DataResult<Repo> =
        safeApiCall { api.getRepo(login, repoName).toDomain() }

    override suspend fun getRepoTags(login: String, repoName: String): DataResult<List<Tag>> =
        safeApiCall { api.getRepoTags(login, repoName).map { it.toDomain() } }
}
