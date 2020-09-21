package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.EquipmentData
import com.dsm.gym.data.entity.EquipmentListData
import io.reactivex.Completable
import io.reactivex.Single

interface EquipmentDataSource {
    fun postDetailEquipment(equipment: EquipmentData): Completable

    fun getAllEquipment(): Single<List<EquipmentListData>>
}