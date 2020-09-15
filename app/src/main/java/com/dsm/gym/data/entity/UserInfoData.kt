package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.UserInfoEntity

data class UserInfoData(
    val studentName: String,
    val studentNumber: String
)

fun UserInfoData.toEntity() =
    UserInfoEntity(
        studentName = studentName,
        studentNumber = studentNumber
    )