package com.example.github.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepoDto(
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String?,
    @Json(name = "open_issues_count") val openIssuesCount: Int,
    @Json(name = "forks_count") val forksCount: Int,
    @Json(name = "watchers_count") val watchersCount: Int,
)
