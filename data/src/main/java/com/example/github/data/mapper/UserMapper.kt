package com.example.github.data.mapper

import com.example.github.data.dto.UserDto
import com.example.github.domain.model.User

internal fun UserDto.toDomain(): User = User(
    login = login,
    avatarUrl = avatarUrl,
    name = name,
)
