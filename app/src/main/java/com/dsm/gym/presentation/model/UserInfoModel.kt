package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.UserInfoEntity

data class UserInfoModel(
    val studentName: String,
    val studentNumber: String
)

fun UserInfoModel.toEntity() =
    UserInfoEntity(
        studentName = studentName,
        studentNumber = studentNumber
    )