package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ApplyExerciseRepository {
    fun applyExercise(time : Int) : Completable

    fun getAppliedExercisePersonnel(time : Int) : Single<List<UserEntity>>

}