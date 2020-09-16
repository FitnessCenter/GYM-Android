package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ApplyExerciseData
import com.dsm.gym.data.entity.UserData
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response

interface ApplyExerciseDataSource {
    fun applyExercise(time : Int) : Completable

    fun getAppliedExercisePersonnel(time : Int) : Single<List<UserData>>

    fun getApplyExerciseState() : Single<List<ApplyExerciseData>>

    fun cancelApplyExercise() : Completable

}