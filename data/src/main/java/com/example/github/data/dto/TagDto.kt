package com.example.github.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class TagDto(
    @Json(name = "name") val name: String,
    @Json(name = "commit") val commit: CommitRefDto,
)

@JsonClass(generateAdapter = true)
internal data class CommitRefDto(
    @Json(name = "sha") val sha: String,
)
