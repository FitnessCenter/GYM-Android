package com.dsm.gym.data.repository

import android.util.Log
import com.dsm.gym.data.datasource.EquipmentDataSource
import com.dsm.gym.data.mapper.EquipmentDataMapper
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.repository.EquipmentRepository
import io.reactivex.Flowable
import retrofit2.Response

class EquipmentRepositoryImpl(
    private val equipmentDataSource: EquipmentDataSource,
    private val equipmentDataMapper: EquipmentDataMapper
):EquipmentRepository{
    override fun postDetailEquipment(equipment: EquipmentEntity): Flowable<Response<Unit>> {
        return equipmentDataSource.postDetailEquipment(equipmentDataMapper.mapFrom(equipment))
    }


    override fun getAllEquipment(): Flowable<List<EquipmentEntity>> =
        equipmentDataSource.getAllEquipment().map{list -> list.map { equipmentDataMapper.mapDataToEntity(it) }}

}