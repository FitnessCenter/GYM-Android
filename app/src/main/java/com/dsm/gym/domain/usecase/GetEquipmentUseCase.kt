package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.service.EquipmentService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetEquipmentUseCase(private val equipmentService: EquipmentService, composite: CompositeDisposable):
    UseCase<Unit, Result<List<EquipmentListEntity>>>(composite) {

    override fun create(data: Unit): Single<Result<List<EquipmentListEntity>>> =
        equipmentService.getAllEquipment()

}