package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ExerciseTimeData
import com.dsm.gym.data.remote.Api
import io.reactivex.Single

class HomePageDataSourceImpl(
    private val api: Api
) :HomePageDataSource{
    override fun getNumOfDaysExercised(): Single<ExerciseTimeData> =
        api.getNumOfDaysExercised()
}