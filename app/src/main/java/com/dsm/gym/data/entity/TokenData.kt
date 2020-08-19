package com.dsm.gym.data.entity

import com.google.gson.annotations.SerializedName

data class TokenData(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)