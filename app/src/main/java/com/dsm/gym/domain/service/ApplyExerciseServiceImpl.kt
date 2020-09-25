package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.extensions.toResult
import com.dsm.gym.domain.extensions.toSingleResult
import com.dsm.gym.domain.repository.ApplyExerciseRepository
import io.reactivex.Single

class ApplyExerciseServiceImpl(private val repository: ApplyExerciseRepository, private val handler: ErrorHandler) : ApplyExerciseService {
    override fun applyExercise(time: Int) : Single<Result<Unit>> = repository.applyExercise(time).toSingleResult(handler)

    override fun getAppliedExercisePersonnel(time: Int): Single<Result<List<UserInfoEntity>>> =repository.getAppliedExercisePersonnel(time).toResult(handler)

    override fun getApplyExerciseState(): Single<Result<List<ApplyExerciseEntity>>> = repository.getApplyExerciseState().toResult(handler)

    override fun cancelApplyExerciseState(): Single<Result<Unit>> =  repository.cancelApplyExerciseState().toSingleResult(handler)


}