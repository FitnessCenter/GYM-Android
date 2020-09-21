package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.AuthEntity
import com.google.gson.annotations.SerializedName

data class AuthData(
    @SerializedName("id")
    val id: String,
    @SerializedName("password")
    val password: String
)

fun AuthEntity.toDataEntity() =
    AuthData(
        id = id,
        password = password
    )

fun AuthData.toEntity() =
    AuthEntity(
        id = id,
        password = password
    )