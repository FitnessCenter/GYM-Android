package com.dsm.gym.data.entity

import com.google.gson.annotations.SerializedName

data class AuthData(
    @SerializedName("email")
    val id: String,
    @SerializedName("password")
    val password: String
)