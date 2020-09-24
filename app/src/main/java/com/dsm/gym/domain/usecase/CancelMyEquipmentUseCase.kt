package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.service.EquipmentService
import com.dsm.gym.domain.base.*
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class CancelMyEquipmentUseCase(private val service : EquipmentService, composite : CompositeDisposable) : UseCase<Int, Result<Unit>>(composite)  {
    override fun create(data: Int): Single<Result<Unit>> = service.cancelMyEquipment(data)
}