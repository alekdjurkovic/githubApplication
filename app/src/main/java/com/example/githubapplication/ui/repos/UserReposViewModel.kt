package com.example.githubapplication.ui.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.domain.model.DataResult
import com.example.github.domain.usecase.GetUserReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val GITHUB_USER = "octocat"

@HiltViewModel
class UserReposViewModel @Inject constructor(
    private val getUserReposUseCase: GetUserReposUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(UserReposState())
    val state: StateFlow<UserReposState> = _state.asStateFlow()

    private val _sideEffects = Channel<UserReposSideEffect>(Channel.BUFFERED)
    val sideEffects = _sideEffects.receiveAsFlow()

    init {
        processIntent(UserReposIntent.LoadRepos)
    }

    fun processIntent(intent: UserReposIntent) {
        when (intent) {
            is UserReposIntent.LoadRepos -> loadRepos()
            is UserReposIntent.RepoClicked -> onRepoClicked(intent.repoName)
        }
    }

    private fun loadRepos() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = getUserReposUseCase(GITHUB_USER)) {
                is DataResult.Success ->
                    _state.value = _state.value.copy(isLoading = false, repos = result.data)
                is DataResult.Error ->
                    _state.value = _state.value.copy(isLoading = false, error = result.message)
            }
        }
    }

    private fun onRepoClicked(repoName: String) {
        viewModelScope.launch {
            _sideEffects.send(UserReposSideEffect.NavigateToRepoDetail(repoName))
        }
    }
}
