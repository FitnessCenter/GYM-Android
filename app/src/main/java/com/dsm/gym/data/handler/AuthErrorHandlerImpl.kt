package com.dsm.gym.data.handler

import android.util.Log
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.handler.AuthErrorHandler
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

class AuthErrorHandlerImpl: AuthErrorHandler{
    override fun signInErrorHandle(throwable: Throwable): ErrorHandlerEntity{
        Log.d("df",throwable.toString())
        return when(throwable){
            is HttpException -> when(throwable.code()){
                200 -> ErrorHandlerEntity(isSuccess = true)
                404 -> ErrorHandlerEntity(message = "404 에러")
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