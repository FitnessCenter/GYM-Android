package com.dsm.gym.domain.base

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()

    data class Error<T>(val message: Message) : Result<T>()
}