package com.dsm.gym.domain.base

interface ErrorHandler {
    fun errorHandle(throwable: Throwable): Message
}