package com.dsm.gym.data.entity

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("studentNumber")
    val studentNumber: String,
    @SerializedName("studentName")
    val studentName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("sex")
    val sex: Boolean
)