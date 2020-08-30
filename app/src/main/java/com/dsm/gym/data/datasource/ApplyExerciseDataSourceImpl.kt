package com.dsm.gym.data.datasource

import com.dsm.gym.data.remote.Api
import io.reactivex.Single
import retrofit2.Response

class ApplyExerciseDataSourceImpl(private val api: Api) : ApplyExerciseDataSource {
    override fun applyExercise(): Single<Response<Unit>> {
        TODO("Not yet implemented")
    }
}