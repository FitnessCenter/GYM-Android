package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.service.ApplyExerciseService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetApplyExerciseStateUseCase(private val service: ApplyExerciseService, composite: CompositeDisposable) :
    UseCase<Unit, Result<List<ApplyExerciseEntity>>>(composite){
    override fun create(data: Unit): Single<Result<List<ApplyExerciseEntity>>> = service.getApplyExerciseState()
}