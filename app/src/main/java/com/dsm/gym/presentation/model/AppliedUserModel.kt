package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.AppliedUserEntity

data class AppliedUserModel(
    val studentNumber: Int = 0,
    val studentName: String = ""
)

fun AppliedUserModel.toEntity() =
    AppliedUserEntity(
        studentNumber = studentNumber,
        studentName = studentName
    )

fun AppliedUserEntity.toModel() =
    AppliedUserModel(
        studentNumber = studentNumber,
        studentName = studentName
    )