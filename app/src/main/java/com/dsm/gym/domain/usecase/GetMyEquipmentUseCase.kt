package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.service.EquipmentService
import com.dsm.gym.domain.base.*
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetMyEquipmentUseCase(private val service : EquipmentService,composite : CompositeDisposable) : UseCase<String, Result<List<EquipmentListEntity>>>(composite) {
    override fun create(data: String): Single<Result<List<EquipmentListEntity>>> =
        service.getMyEquipment(data)

}