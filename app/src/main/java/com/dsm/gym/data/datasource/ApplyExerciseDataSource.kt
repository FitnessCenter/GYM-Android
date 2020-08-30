package com.dsm.gym.data.datasource

import io.reactivex.Single
import retrofit2.Response

interface ApplyExerciseDataSource {
    fun applyExercise() : Single<Response<Unit>>
}