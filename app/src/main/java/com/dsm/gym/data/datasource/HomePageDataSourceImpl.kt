package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.ExerciseDayData
import com.dsm.gym.data.entity.ExerciseTimeData
import com.dsm.gym.data.entity.UserInfoData
import com.dsm.gym.data.remote.Api
import io.reactivex.Single

class HomePageDataSourceImpl(
    private val api: Api
) :HomePageDataSource{
    override fun getNumOfDaysExercised(): Single<ExerciseDayData> =
        api.getNumOfDaysExercised()

    override fun getUserInfo(): Single<UserInfoData> =
        api.getUserInfo()

    override fun getApplyTime(): Single<ExerciseTimeData> =
        api.getApplyTime()
}