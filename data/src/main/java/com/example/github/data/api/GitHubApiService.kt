package com.example.github.data.api

import com.example.github.data.dto.RepoDto
import com.example.github.data.dto.TagDto
import com.example.github.data.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {

    @GET("users/{login}")
    suspend fun getUser(@Path("login") login: String): UserDto

    @GET("users/{login}/repos")
    suspend fun getUserRepos(@Path("login") login: String): List<RepoDto>

    @GET("repos/{login}/{repo}")
    suspend fun getRepo(
        @Path("login") login: String,
        @Path("repo") repo: String,
    ): RepoDto

    @GET("repos/{login}/{repo}/tags")
    suspend fun getRepoTags(
        @Path("login") login: String,
        @Path("repo") repo: String,
    ): List<TagDto>
}
