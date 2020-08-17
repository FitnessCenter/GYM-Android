package com.dsm.gym.data.entity

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("schoolNum")
    val studentNumber: Int,
    @SerializedName("name")
    val studentName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("gender")
    val sex: Boolean
)