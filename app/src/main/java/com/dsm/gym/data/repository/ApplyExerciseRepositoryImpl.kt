package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.ApplyExerciseDataSource
import com.dsm.gym.domain.repository.ApplyExerciseRepository
import io.reactivex.Single
import retrofit2.Response

class ApplyExerciseRepositoryImpl(private val dataSource: ApplyExerciseDataSource) : ApplyExerciseRepository {
    override fun applyExercise(): Single<Response<Unit>> = dataSource.applyExercise()
}