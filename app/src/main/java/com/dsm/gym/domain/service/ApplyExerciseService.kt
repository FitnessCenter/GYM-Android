package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.extensions.toResult
import io.reactivex.Single

interface ApplyExerciseService {
    fun applyExercise(time : Int) : Single<Result<Unit>>

    fun getAppliedExercisePersonnel(time: Int) : Single<Result<List<UserEntity>>>

    fun getApplyExerciseState(): Single<Result<List<ApplyExerciseEntity>>>

    fun cancelApplyExerciseState(): Single<Result<Unit>>

}