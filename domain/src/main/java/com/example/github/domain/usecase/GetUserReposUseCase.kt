package com.example.github.domain.usecase

import com.example.github.domain.config.AppConfig
import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.repository.RepoRepository

class GetUserReposUseCase(private val repository: RepoRepository) {
    suspend operator fun invoke(): DataResult<List<Repo>> =
        repository.getUserRepos(AppConfig.GITHUB_USER)
}
