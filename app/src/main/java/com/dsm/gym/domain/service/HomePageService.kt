package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ExerciseTimeEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import io.reactivex.Single

interface HomePageService{
    fun getNumOfDaysExercised(): Single<Result<ExerciseTimeEntity>>

    fun getUserInfo(): Single<Result<UserInfoEntity>>
}