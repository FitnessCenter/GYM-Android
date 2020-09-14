package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.repository.EquipmentRepository
import com.dsm.gym.domain.toResult
import com.dsm.gym.domain.toSingleResult
import io.reactivex.Single

class EquipmentServiceImpl(
    private val equipmentRepository: EquipmentRepository,
    private val handler: ErrorHandler
) : EquipmentService {
    override fun postDetailEquipment(equipmentEntity: EquipmentEntity): Single<Result<Unit>> =
        equipmentRepository.postDetailEquipment(equipmentEntity).toSingleResult(handler)

    override fun getAllEquipment(): Single<Result<List<EquipmentListEntity>>> =
        equipmentRepository.getAllEquipment().toResult(handler)

}