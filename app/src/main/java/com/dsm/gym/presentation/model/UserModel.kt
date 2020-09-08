package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.UserEntity

data class UserModel(
    val studentNumber: String = "",
    val studentName: String = "",
    val id: String = "",
    val password: String = "",
    val sex: Boolean = true
)


fun UserModel.toEntity() =
    UserEntity(
        id = id,
        password = password,
        studentName = studentName,
        studentNumber = studentNumber,
        sex = sex
    )

fun UserEntity.toModel() =
    UserModel(
        id = id,
        password = password,
        studentNumber = studentNumber,
        studentName = studentName,
        sex = sex
    )