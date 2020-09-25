package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.service.ApplyExerciseService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.dsm.gym.domain.base.*
class CancelApplyExerciseUseCase(private val service: ApplyExerciseService,composite: CompositeDisposable) : UseCase<Unit, Result<Unit>>(composite){
    override fun create(data: Unit): Single<Result<Unit>> = service.cancelApplyExerciseState()
}