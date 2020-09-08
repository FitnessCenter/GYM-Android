package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.EquipmentData
import com.dsm.gym.data.remote.Api
import io.reactivex.Completable

class EquipmentDataSourceImpl(
    private val api: Api
) : EquipmentDataSource {
    override fun postDetailEquipment(equipment: EquipmentData): Completable =
        api.postDetailEquipment(equipment)
//
//    override fun getAllEquipment(): Flowable<List<EquipmentData>> =
//        api.getAllEquipment()
}