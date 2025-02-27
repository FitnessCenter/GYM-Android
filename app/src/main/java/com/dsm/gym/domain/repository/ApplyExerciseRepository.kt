package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ApplyExerciseRepository {
    fun applyExercise(time: Int): Completable

    fun getAppliedExercisePersonnel(time: Int): Single<List<UserInfoEntity>>

    fun getApplyExerciseState(): Single<List<ApplyExerciseEntity>>

    fun cancelApplyExerciseState(): Completable
}