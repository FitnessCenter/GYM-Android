package com.dsm.gym.domain.handler

import com.dsm.gym.domain.base.Message

interface ErrorHandler {
    fun errorHandle(throwable: Throwable): Message
}