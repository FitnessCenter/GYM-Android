package com.dsm.gym.domain.repository

import io.reactivex.Single
import retrofit2.Response

interface ApplyExerciseRepository {
    fun applyExercise() : Single<Response<Unit>>
}