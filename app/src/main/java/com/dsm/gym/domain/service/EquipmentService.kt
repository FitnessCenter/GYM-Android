package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.EquipmentEntity
import io.reactivex.Flowable
import retrofit2.Response

interface EquipmentService {
    fun postDetailEquipment(equipmentEntity: EquipmentEntity): Flowable<Pair<Response<Unit>, ErrorHandlerEntity>>

    fun getAllEquipment(): Flowable<Pair<List<EquipmentEntity>, ErrorHandlerEntity>>
}