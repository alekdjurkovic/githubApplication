package com.example.githubapplication.ui.repos

import com.example.github.domain.model.Repo

data class UserReposState(
    val isLoading: Boolean = false,
    val repos: List<Repo> = emptyList(),
    val error: String? = null,
)

sealed interface UserReposIntent {
    data object LoadRepos : UserReposIntent
    data class RepoClicked(val repoName: String) : UserReposIntent
}

sealed interface UserReposSideEffect {
    data class NavigateToRepoDetail(val repoName: String) : UserReposSideEffect
}
