package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.ChangePasswordEntity

data class ChangePasswordData(
    val newPassword : String,
    val currentPassword : String
)

fun ChangePasswordData.toEntity() =
    ChangePasswordEntity(
        this.newPassword,
        this.currentPassword
    )

fun ChangePasswordEntity.toData() =
    ChangePasswordData(
        this.newPassword,
        this.currentPassword
    )