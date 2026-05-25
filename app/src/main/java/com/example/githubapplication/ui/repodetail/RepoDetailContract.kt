package com.example.githubapplication.ui.repodetail

import com.example.github.domain.usecase.RepoDetails

data class RepoDetailState(
    val isLoading: Boolean = false,
    val details: RepoDetails? = null,
    val error: String? = null,
)

sealed interface RepoDetailIntent {
    data class Load(val repoName: String) : RepoDetailIntent
}
