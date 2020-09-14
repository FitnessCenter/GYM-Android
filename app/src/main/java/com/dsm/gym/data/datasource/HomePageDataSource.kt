package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ExerciseTimeData
import io.reactivex.Single

interface HomePageDataSource {
    fun getNumOfDaysExercised(): Single<ExerciseTimeData>
}