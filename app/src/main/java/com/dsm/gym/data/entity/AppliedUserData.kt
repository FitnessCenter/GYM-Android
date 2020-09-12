package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.AppliedUserEntity

data class AppliedUserData(
    val studentNumber: Int = 0,
    val studentName: String = ""
)

fun AppliedUserData.toEntity() =
    AppliedUserEntity(
        studentNumber = studentNumber.toString(),
        studentName = studentName
    )
