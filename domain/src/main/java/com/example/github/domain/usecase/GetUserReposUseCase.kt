package com.example.github.domain.usecase

import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.repository.RepoRepository

class GetUserReposUseCase(private val repository: RepoRepository) {
    suspend operator fun invoke(login: String): DataResult<List<Repo>> =
        repository.getUserRepos(login)
}
