package com.dsm.gym.domain.service

import android.util.Log
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.handler.EquipmentErrorHandler
import com.dsm.gym.domain.repository.EquipmentRepository
import io.reactivex.Flowable
import retrofit2.Response

class EquipmentServiceImpl(
    private val equipmentRepository: EquipmentRepository,
    private val equipmentErrorHandler: EquipmentErrorHandler
) : EquipmentService {
    override fun postDetailEquipment(equipmentEntity: EquipmentEntity): Flowable<Pair<Response<Unit>, ErrorHandlerEntity>> {
        Log.d("postDetailEquipment",equipmentEntity.toString())
        return equipmentRepository.postDetailEquipment(equipmentEntity).map {
            it to ErrorHandlerEntity(isSuccess = true)
        }.onErrorReturn {
            equipmentRepository.postDetailEquipment(equipmentEntity) to equipmentErrorHandler.postDetailEquipmentErrorHandle(it)
        }
    }

    override fun getAllEquipment(): Flowable<Pair<List<EquipmentEntity>, ErrorHandlerEntity>> =
        equipmentRepository.getAllEquipment().map {
            it to ErrorHandlerEntity(isSuccess = true)
        }.doOnNext {
            Log.d("equipmentData", "${it.first[0]}, ${it.second.message}")
        }
}
//    }.onErrorReturn {
//        equipmentRepository.getAllEquipment() to equipmentErrorHandler.getAllEquipmentErrorHandle(it)
//    }
//}