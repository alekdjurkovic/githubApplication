package com.example.githubapplication.ui.repodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.domain.model.DataResult
import com.example.github.domain.usecase.GetRepoDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val GITHUB_USER = "octocat"

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getRepoDetailsUseCase: GetRepoDetailsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(RepoDetailState())
    val state: StateFlow<RepoDetailState> = _state.asStateFlow()

    init {
        val repoName = checkNotNull(savedStateHandle.get<String>("repoName"))
        processIntent(RepoDetailIntent.Load(repoName))
    }

    fun processIntent(intent: RepoDetailIntent) {
        when (intent) {
            is RepoDetailIntent.Load -> loadDetails(intent.repoName)
        }
    }

    private fun loadDetails(repoName: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            when (val result = getRepoDetailsUseCase(GITHUB_USER, repoName)) {
                is DataResult.Success ->
                    _state.value = _state.value.copy(isLoading = false, details = result.data)
                is DataResult.Error ->
                    _state.value = _state.value.copy(isLoading = false, error = result.message)
            }
        }
    }
}
