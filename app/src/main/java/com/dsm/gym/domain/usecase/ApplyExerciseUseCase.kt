package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.service.ApplyExerciseService
import com.dsm.gym.domain.base.Result
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class ApplyExerciseUseCase(private val service : ApplyExerciseService,compositeDisposable: CompositeDisposable) : UseCase<Result<Unit>, Int>(compositeDisposable){
    override fun create(data: Int): Single<Result<Unit>> = service.applyExercise(data)
}