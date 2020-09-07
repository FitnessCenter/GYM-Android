package com.dsm.gym.data.handler

import android.util.Log
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.handler.EquipmentErrorHandler
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

class EquipmentErrorHandlerImpl: EquipmentErrorHandler{
    override fun getAllEquipmentErrorHandle(throwable: Throwable): ErrorHandlerEntity {
        TODO("Not yet implemented")
    }

    override fun postDetailEquipmentErrorHandle(throwable: Throwable): ErrorHandlerEntity {
        Log.d("errorhandler",throwable.message.toString())
        return when(throwable){
            is HttpException -> when(throwable.code()){
                201 -> ErrorHandlerEntity(isSuccess = true)
                400 -> ErrorHandlerEntity(message = "400")
                500 -> ErrorHandlerEntity(message = "500")
                else -> ErrorHandlerEntity(message = "unknown error execute")
            }
            is ConnectException -> ErrorHandlerEntity(message = "인터넷 연결이 되지 않았습니다")
            is SocketTimeoutException -> ErrorHandlerEntity(message = "인터넷 연결이 불안정합니다")
            else -> ErrorHandlerEntity()
        }
    }

}