package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.UserData
import com.dsm.gym.data.remote.Api
import io.reactivex.Completable
import io.reactivex.Single


class ApplyExerciseDataSourceImpl(private val api: Api) : ApplyExerciseDataSource {

    override fun applyExercise(time : Int) : Completable = api.applyExercise(time)

    override fun getAppliedExercisePersonnel(time: Int): Single<List<UserData>> = api.getAppliedExercisePersonnel(time)
}