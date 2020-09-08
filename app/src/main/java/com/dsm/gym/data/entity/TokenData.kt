package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.TokenEntity
import com.google.gson.annotations.SerializedName

data class TokenData(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)

fun TokenEntity.toDataToken() =
    TokenData(
        accessToken = accessToken,
        refreshToken = refreshToken
    )

fun TokenData.toEntity() =
    TokenEntity(
        accessToken = accessToken,
        refreshToken = refreshToken
    )