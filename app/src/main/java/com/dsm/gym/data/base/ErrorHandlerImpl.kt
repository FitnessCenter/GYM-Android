package com.dsm.gym.data.base

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Message.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandlerImpl: ErrorHandler {
    override fun errorHandle(throwable: Throwable): Message =
        when (throwable) {
            is HttpException -> when(throwable.code()) {
                204 -> NO_CONTENT
                400 -> INVALID
                401 -> UNAUTHORIZED
                404 -> NOT_FOUND
                403 -> FORBIDDEN
                409 -> CONFLICT
                500 -> SERVER_ERROR
                else -> UNKNOWN_ERROR
            }
            is ConnectException, is SocketTimeoutException, is UnknownHostException -> NETWORK_ERROR
            else -> UNKNOWN_ERROR
        }
}