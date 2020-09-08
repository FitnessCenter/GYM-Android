package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.EquipmentData
import io.reactivex.Completable
import io.reactivex.Flowable

interface EquipmentDataSource {
    fun postDetailEquipment(equipment: EquipmentData): Completable

    //fun getAllEquipment(): Flowable<List<EquipmentData>>
}