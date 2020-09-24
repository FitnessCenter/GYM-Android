package com.dsm.gym.domain.service

import com.dsm.gym.data.entity.EquipmentListData
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.entity.EquipmentListEntity
import io.reactivex.Completable
import io.reactivex.Single

interface EquipmentService {
    fun postDetailEquipment(equipmentEntity: EquipmentEntity): Single<Result<Unit>>

    fun getAllEquipment(): Single<Result<List<EquipmentListEntity>>>

    fun getMyEquipment(whose : String): Single<Result<List<EquipmentListEntity>>>

    fun cancelMyEquipment(applyEquipmentId : Int): Single<Result<Unit>>

}