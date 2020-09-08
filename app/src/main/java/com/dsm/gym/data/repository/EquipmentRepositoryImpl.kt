package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.EquipmentDataSource
import com.dsm.gym.data.entity.toDataEntity
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.repository.EquipmentRepository
import io.reactivex.Completable

class EquipmentRepositoryImpl(
    private val equipmentDataSource: EquipmentDataSource
):EquipmentRepository{
    override fun postDetailEquipment(equipment: EquipmentEntity): Completable =
        equipmentDataSource.postDetailEquipment(equipment.toDataEntity())
//
//    override fun getAllEquipment(): Flowable<List<EquipmentEntity>> =
//        equipmentDataSource.getAllEquipment().map{list -> list.map { equipmentDataMapper.mapDataToEntity(it) }}

}