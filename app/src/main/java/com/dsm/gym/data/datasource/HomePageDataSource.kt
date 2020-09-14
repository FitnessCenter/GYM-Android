package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ExerciseDayData
import com.dsm.gym.data.entity.UserInfoData
import io.reactivex.Single

interface HomePageDataSource {
    fun getNumOfDaysExercised(): Single<ExerciseDayData>

    fun getUserInfo(): Single<UserInfoData>
}