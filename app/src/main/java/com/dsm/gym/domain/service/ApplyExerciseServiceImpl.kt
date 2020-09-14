package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.extensions.toResult
import com.dsm.gym.domain.extensions.toSingleResult
import com.dsm.gym.domain.repository.ApplyExerciseRepository
import io.reactivex.Single
import com.dsm.gym.domain.handler.ErrorHandler

class ApplyExerciseServiceImpl(private val repository: ApplyExerciseRepository, private val handler: ErrorHandler) : ApplyExerciseService {
    override fun applyExercise(time: Int) : Single<Result<Unit>> = repository.applyExercise(time).toSingleResult(handler)

    override fun getAppliedExercisePersonnel(time: Int): Single<Result<List<UserEntity>>> =repository.getAppliedExercisePersonnel(time).toResult(handler)
}