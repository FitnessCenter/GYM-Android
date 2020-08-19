package com.dsm.gym.domain.entity

data class TokenEntity(
    val accessToken: String = "",
    val refreshToken: String = ""
)