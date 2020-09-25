package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.UserInfoEntity

data class UserInfoModel(
    val studentName: String,
    val studentNumber: String
)

fun UserInfoEntity.toModel() =
    UserInfoModel(
        studentName = studentName,
        studentNumber = studentNumber
    )