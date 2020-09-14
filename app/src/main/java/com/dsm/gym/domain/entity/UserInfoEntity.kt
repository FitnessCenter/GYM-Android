package com.dsm.gym.domain.entity

import com.dsm.gym.presentation.model.UserInfoModel

data class UserInfoEntity(
    val studentName: String,
    val studentNumber: String
)

fun UserInfoEntity.toModel() =
    UserInfoModel(
        studentName = studentName,
        studentNumber = studentNumber
    )