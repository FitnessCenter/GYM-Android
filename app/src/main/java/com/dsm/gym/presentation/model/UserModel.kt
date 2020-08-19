package com.dsm.gym.presentation.model

data class UserModel(
    val studentNumber: String = "",
    val studentName: String = "",
    val id: String = "",
    val password: String = "",
    val sex: Boolean = true
)