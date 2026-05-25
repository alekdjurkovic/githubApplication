package com.example.githubapplication.di

import com.example.github.domain.repository.RepoRepository
import com.example.github.domain.repository.UserRepository
import com.example.github.domain.usecase.GetRepoDetailsUseCase
import com.example.github.domain.usecase.GetUserReposUseCase
import com.example.github.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase =
        GetUserUseCase(userRepository)

    @Provides
    @ViewModelScoped
    fun provideGetUserReposUseCase(repoRepository: RepoRepository): GetUserReposUseCase =
        GetUserReposUseCase(repoRepository)

    @Provides
    @ViewModelScoped
    fun provideGetRepoDetailsUseCase(
        userRepository: UserRepository,
        repoRepository: RepoRepository,
    ): GetRepoDetailsUseCase = GetRepoDetailsUseCase(userRepository, repoRepository)
}
