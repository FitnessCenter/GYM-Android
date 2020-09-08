package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.repository.EquipmentRepository
import com.dsm.gym.domain.toSingleResult
import io.reactivex.Single

class EquipmentServiceImpl(
    private val equipmentRepository: EquipmentRepository,
    private val handler: ErrorHandler
) : EquipmentService {
    override fun postDetailEquipment(equipmentEntity: EquipmentEntity): Single<Result<Unit>> =
        equipmentRepository.postDetailEquipment(equipmentEntity).toSingleResult(handler)

//    override fun getAllEquipment(): Flowable<Pair<List<EquipmentEntity>, ErrorHandlerEntity>> =
//        equipmentRepository.getAllEquipment().map {
//            it to ErrorHandlerEntity(isSuccess = true)
//        }.doOnNext {
//            Log.d("equipmentData", "${it.first[0]}, ${it.second.message}")
//        }
}
//    }.onErrorReturn {
//        equipmentRepository.getAllEquipment() to equipmentErrorHandler.getAllEquipmentErrorHandle(it)