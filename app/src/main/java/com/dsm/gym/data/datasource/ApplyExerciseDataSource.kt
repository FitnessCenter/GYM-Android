package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ApplyExerciseData
import com.dsm.gym.data.entity.UserInfoData
import io.reactivex.Completable
import io.reactivex.Single

interface ApplyExerciseDataSource {
    fun applyExercise(time : Int) : Completable

    fun getAppliedExercisePersonnel(time : Int) : Single<List<UserInfoData>>

    fun getApplyExerciseState() : Single<List<ApplyExerciseData>>

    fun cancelApplyExercise() : Completable

}