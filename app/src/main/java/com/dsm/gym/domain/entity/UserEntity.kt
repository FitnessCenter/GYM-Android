package com.dsm.gym.domain.entity

data class UserEntity(
    val studentNumber: Int = 0,
    val studentName: String = "",
    val id: String = "",
    val password: String = "",
    val sex: Boolean = true
)