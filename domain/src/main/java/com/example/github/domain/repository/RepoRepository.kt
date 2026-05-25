package com.example.github.domain.repository

import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag

interface RepoRepository {
    suspend fun getUserRepos(login: String): DataResult<List<Repo>>
    suspend fun getRepo(login: String, repoName: String): DataResult<Repo>
    suspend fun getRepoTags(login: String, repoName: String): DataResult<List<Tag>>
}
