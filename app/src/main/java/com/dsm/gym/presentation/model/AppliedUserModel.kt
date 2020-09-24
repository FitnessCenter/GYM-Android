package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.AppliedUserEntity

data class AppliedUserModel(
    val studentNumber: Int = 0,
    val studentName: String = ""
)

fun AppliedUserModel.toEntity() =
    AppliedUserEntity(
        studentNumber = studentNumber.toString(),
        studentName = studentName
    )
