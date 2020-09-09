package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.AppliedUserEntity

data class AppliedUserData(
    val studentNumber: Int = 0,
    val studentName: String = ""
)

fun AppliedUserEntity.toDataEntity() =
    AppliedUserData(
        studentNumber = studentNumber,
        studentName = studentName
    )

fun AppliedUserData.toEntity() =
    AppliedUserEntity(
        studentNumber = studentNumber,
        studentName = studentName
    )
