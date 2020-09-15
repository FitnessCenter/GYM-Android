package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.service.ApplyExerciseService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetAppliedExercisePersonnelUsecase(private val service : ApplyExerciseService, compositeDisposable: CompositeDisposable)
    : UseCase<Result<List<UserEntity>>, Int>(compositeDisposable){
    override fun create(data: Int): Single<Result<List<UserEntity>>> =service.getAppliedExercisePersonnel(data)
}