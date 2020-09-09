package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.entity.EquipmentListEntity
import io.reactivex.Completable
import io.reactivex.Single

interface EquipmentRepository {
    fun postDetailEquipment(equipment: EquipmentEntity): Completable

    fun getAllEquipment(): Single<List<EquipmentListEntity>>
}