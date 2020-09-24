package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.AuthEntity

data class AuthModel(
    var id: String = "",
    var password: String = ""
)

fun AuthModel.toEntity() =
    AuthEntity(
        id = id,
        password = password
    )