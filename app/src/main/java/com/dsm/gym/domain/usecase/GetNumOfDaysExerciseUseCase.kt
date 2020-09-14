package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.ExerciseDayEntity
import com.dsm.gym.domain.service.HomePageService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetNumOfDaysExerciseUseCase(private val service: HomePageService, composite: CompositeDisposable):
    UseCase<Unit, Result<ExerciseDayEntity>>(composite){

    override fun create(data: Unit): Single<Result<ExerciseDayEntity>> =
        service.getNumOfDaysExercised()
}