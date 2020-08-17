package com.dsm.gym.domain.base

data class ErrorHandlerEntity(
    val message: String = "",
    val isSuccess: Boolean = false
)