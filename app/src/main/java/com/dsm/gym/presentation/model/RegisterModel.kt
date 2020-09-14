package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.RegisterEntity

data class RegisterModel(
    val studentNumber: String = "",
    val studentName: String = "",
    val id: String = "",
    val password: String = "",
    val sex: Boolean = true
)


fun RegisterModel.toEntity() =
    RegisterEntity(
        id = id,
        password = password,
        studentName = studentName,
        studentNumber = studentNumber,
        sex = sex
    )