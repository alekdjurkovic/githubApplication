package com.example.github.domain.usecase

import com.example.github.domain.model.DataResult
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag
import com.example.github.domain.repository.RepoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetUserReposUseCaseTest {

    private val repos = listOf(
        Repo(name = "Hello-World", description = "My first repo", openIssuesCount = 2, forksCount = 10, watchersCount = 5),
        Repo(name = "Spoon-Knife", description = null, openIssuesCount = 0, forksCount = 3, watchersCount = 1),
    )

    @Test
    fun `returns success with repos when repository call succeeds`() = runTest {
        val useCase = GetUserReposUseCase(FakeRepoRepository(DataResult.Success(repos)))

        val result = useCase()

        assertEquals(DataResult.Success(repos), result)
    }

    @Test
    fun `returns error when repository call fails`() = runTest {
        val error = DataResult.Error("Network error. Check your connection.")
        val useCase = GetUserReposUseCase(FakeRepoRepository(error))

        val result = useCase()

        assertTrue(result is DataResult.Error)
        assertEquals("Network error. Check your connection.", (result as DataResult.Error).message)
    }

    @Test
    fun `delegates call to repository with correct github user`() = runTest {
        val fake = FakeRepoRepository(DataResult.Success(repos))
        val useCase = GetUserReposUseCase(fake)

        useCase()

        assertEquals("octocat", fake.lastLoginRequested)
    }
}

private class FakeRepoRepository(
    private val getUserReposResult: DataResult<List<Repo>>,
) : RepoRepository {

    var lastLoginRequested: String? = null

    override suspend fun getUserRepos(login: String): DataResult<List<Repo>> {
        lastLoginRequested = login
        return getUserReposResult
    }

    override suspend fun getRepo(login: String, repoName: String): DataResult<Repo> =
        throw UnsupportedOperationException("not used in this test")

    override suspend fun getRepoTags(login: String, repoName: String): DataResult<List<Tag>> =
        throw UnsupportedOperationException("not used in this test")
}
