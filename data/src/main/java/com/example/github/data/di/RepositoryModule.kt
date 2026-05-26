package com.example.github.data.di

import com.example.github.data.repository.RepoRepositoryImpl
import com.example.github.data.repository.UserRepositoryImpl
import com.example.github.domain.repository.RepoRepository
import com.example.github.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    @Singleton
    internal fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    @Singleton
    internal fun provideRepoRepository(impl: RepoRepositoryImpl): RepoRepository = impl
}
