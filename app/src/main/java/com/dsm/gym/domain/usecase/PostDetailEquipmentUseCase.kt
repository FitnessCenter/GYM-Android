package com.dsm.gym.domain.usecase

import android.util.Log
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.service.EquipmentService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Response

class PostDetailEquipmentUseCase(private val equipmentService: EquipmentService, composite: CompositeDisposable):
    UseCase<Pair<Response<Unit>, ErrorHandlerEntity>, EquipmentEntity>(composite) {

    override fun createFlowable(data: EquipmentEntity): Flowable<Pair<Response<Unit>, ErrorHandlerEntity>>
        = equipmentService.postDetailEquipment(data)
}