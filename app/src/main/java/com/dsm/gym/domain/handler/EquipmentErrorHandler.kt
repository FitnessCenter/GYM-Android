package com.dsm.gym.domain.handler

import com.dsm.gym.domain.base.ErrorHandlerEntity

interface EquipmentErrorHandler{
    fun getAllEquipmentErrorHandle(throwable: Throwable): ErrorHandlerEntity

    fun postDetailEquipmentErrorHandle(throwable: Throwable): ErrorHandlerEntity
}