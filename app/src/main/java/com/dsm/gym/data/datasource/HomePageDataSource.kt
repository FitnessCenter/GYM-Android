package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ExerciseTimeData
import com.dsm.gym.data.entity.UserInfoData
import io.reactivex.Single

interface HomePageDataSource {
    fun getNumOfDaysExercised(): Single<ExerciseTimeData>

    fun getUserInfo(): Single<UserInfoData>
}