package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.UserInfoEntity
import com.google.gson.annotations.SerializedName

data class UserInfoData(
    @SerializedName("studentName")
    val studentName: String,
    @SerializedName("studentNumber")
    val studentNumber: String
)

fun UserInfoData.toEntity() =
    UserInfoEntity(
        studentName = studentName,
        studentNumber = studentNumber
    )