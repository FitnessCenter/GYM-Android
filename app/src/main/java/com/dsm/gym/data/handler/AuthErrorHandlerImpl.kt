package com.dsm.gym.data.handler

import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.handler.AuthErrorHandler
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

class AuthErrorHandlerImpl: AuthErrorHandler{
    override fun signInErrorHandle(throwable: Throwable): ErrorHandlerEntity{
        return when(throwable){
            is HttpException -> when(throwable.code()){
                200 -> ErrorHandlerEntity(isSuccess = true)
                400 -> ErrorHandlerEntity(message = "유저 정보가 일치하지 않습니다.")
                500 -> ErrorHandlerEntity(message = "서버 에러가 발생했습니다")
                else -> ErrorHandlerEntity(message = "unknown error execute")
            }
            is ConnectException -> ErrorHandlerEntity(message = "인터넷 연결이 되지 않았습니다")
            is SocketTimeoutException -> ErrorHandlerEntity(message = "인터넷 연결이 불안정합니다")
            else -> ErrorHandlerEntity()
        }
    }

    override fun signUpErrorHandle(throwable: Throwable): ErrorHandlerEntity
            = when(throwable){
        is HttpException -> when(throwable.code()){
            200 -> ErrorHandlerEntity(isSuccess = true)
            else -> ErrorHandlerEntity(message = "unknown error execute")
        }
        is ConnectException -> ErrorHandlerEntity(message = "인터넷 연결이 되지 않았습니다")
        else -> ErrorHandlerEntity()
    }
}