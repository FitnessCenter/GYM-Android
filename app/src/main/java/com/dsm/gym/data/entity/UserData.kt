package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.UserEntity
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

fun UserData.toEntity() =
    UserEntity(
        studentNumber = studentNumber,
        studentName = studentName,
        id = id,
        password = password,
        sex = sex
    )

fun UserEntity.toDataEntity() =
    UserData(
        studentNumber = studentNumber,
        studentName = studentName,
        id = id,
        password = password,
        sex = sex
    )