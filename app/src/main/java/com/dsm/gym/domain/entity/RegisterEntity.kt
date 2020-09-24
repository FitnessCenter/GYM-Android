package com.dsm.gym.domain.entity

data class RegisterEntity(
    val studentNumber: String = "",
    val studentName: String = "",
    val id: String = "",
    val password: String = "",
    val sex: Boolean = true
)