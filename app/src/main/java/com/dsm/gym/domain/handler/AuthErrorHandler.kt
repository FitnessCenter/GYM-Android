package com.dsm.gym.domain.handler

import com.dsm.gym.domain.base.ErrorHandlerEntity

interface AuthErrorHandler {
    fun signInErrorHandle(throwable: Throwable): ErrorHandlerEntity

    fun signUpErrorHandle(throwable: Throwable): ErrorHandlerEntity
}