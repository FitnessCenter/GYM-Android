package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.EquipmentEntity
import io.reactivex.Flowable
import retrofit2.Response

interface EquipmentRepository {
    fun postDetailEquipment(equipment: EquipmentEntity): Flowable<Response<Unit>>

    fun getAllEquipment(): Flowable<List<EquipmentEntity>>
}