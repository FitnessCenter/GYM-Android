package com.dsm.gym.domain.entity

data class ChangePasswordEntity(
    val newPassword : String,
    val currentPassword : String
)