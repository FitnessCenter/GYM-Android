package com.dsm.gym.domain.entity

import com.google.gson.annotations.SerializedName

data class TokenEntity(
    @SerializedName("access_token")
    val token: String = ""
)