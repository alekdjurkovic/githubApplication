package com.example.github.domain.usecase

import com.example.github.domain.config.AppConfig
import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag
import com.example.github.domain.model.User
import com.example.github.domain.repository.RepoRepository
import com.example.github.domain.repository.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

data class RepoDetails(
    val user: User,
    val repo: Repo,
    val tags: List<Tag>,
)

class GetRepoDetailsUseCase(
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository,
) {
    suspend operator fun invoke(repoName: String): DataResult<RepoDetails> =
        coroutineScope {
            val userDeferred = async { userRepository.getUser(AppConfig.GITHUB_USER) }
            val repoDeferred = async { repoRepository.getRepo(AppConfig.GITHUB_USER, repoName) }
            val tagsDeferred = async { repoRepository.getRepoTags(AppConfig.GITHUB_USER, repoName) }

            val userResult = userDeferred.await()
            val repoResult = repoDeferred.await()
            val tagsResult = tagsDeferred.await()

            val error = listOf(userResult, repoResult, tagsResult)
                .filterIsInstance<DataResult.Error>()
                .firstOrNull()

            if (error != null) return@coroutineScope error

            DataResult.Success(
                RepoDetails(
                    user = (userResult as DataResult.Success).data,
                    repo = (repoResult as DataResult.Success).data,
                    tags = (tagsResult as DataResult.Success).data,
                )
            )
        }
}
