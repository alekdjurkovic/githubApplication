package com.example.github.domain.model

data class Repo(
    val name: String,
    val description: String?,
    val openIssuesCount: Int,
    val forksCount: Int,
    val watchersCount: Int,
)
