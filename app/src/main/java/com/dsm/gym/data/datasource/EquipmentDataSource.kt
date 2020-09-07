package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.EquipmentData
import io.reactivex.Flowable
import retrofit2.Response

interface EquipmentDataSource {
    fun postDetailEquipment(equipment: EquipmentData): Flowable<Response<Unit>>

    fun getAllEquipment(): Flowable<List<EquipmentData>>
}