package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.EquipmentEntity
import io.reactivex.Completable

interface EquipmentRepository {
    fun postDetailEquipment(equipment: EquipmentEntity): Completable

//    fun getAllEquipment(): Flowable<List<EquipmentEntity>>
}