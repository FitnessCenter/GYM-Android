package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.ChangePasswordEntity

data class ChangePasswordModel(
    val newPassword : String,
    val currentPassword : String
)

fun ChangePasswordModel.toEntity()=
    ChangePasswordEntity(
        this.newPassword,
        this.currentPassword
    )