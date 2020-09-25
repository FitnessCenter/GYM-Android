package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.RegisterEntity
import com.google.gson.annotations.SerializedName

data class RegisterData(
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

fun RegisterData.toEntity() =
    RegisterEntity(
        studentNumber = studentNumber,
        studentName = studentName,
        id = id,
        password = password,
        sex = sex
    )

fun RegisterEntity.toDataEntity() =
    RegisterData(
        studentNumber = studentNumber,
        studentName = studentName,
        id = id,
        password = password,
        sex = sex
    )