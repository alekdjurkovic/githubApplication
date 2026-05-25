package com.example.github.data.mapper

import com.example.github.data.dto.RepoDto
import com.example.github.data.dto.TagDto
import com.example.github.domain.model.Repo
import com.example.github.domain.model.Tag

internal fun RepoDto.toDomain(): Repo = Repo(
    name = name,
    description = description,
    openIssuesCount = openIssuesCount,
    forksCount = forksCount,
    watchersCount = watchersCount,
)

internal fun TagDto.toDomain(): Tag = Tag(
    name = name,
    commitSha = commit.sha,
)
