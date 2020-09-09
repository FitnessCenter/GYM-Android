package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.EquipmentDataSource
import com.dsm.gym.data.entity.toDataEntity
import com.dsm.gym.data.entity.toEntity
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.repository.EquipmentRepository
import io.reactivex.Completable
import io.reactivex.Single

class EquipmentRepositoryImpl(
    private val equipmentDataSource: EquipmentDataSource
):EquipmentRepository{
    override fun postDetailEquipment(equipment: EquipmentEntity): Completable =
        equipmentDataSource.postDetailEquipment(equipment.toDataEntity())

    override fun getAllEquipment(): Single<List<EquipmentListEntity>> =
        equipmentDataSource.getAllEquipment().map{ it ->
            it.equipmentList.map{ it.toEntity() }
        }

}