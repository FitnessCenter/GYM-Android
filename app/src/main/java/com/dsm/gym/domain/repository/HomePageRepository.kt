package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.ExerciseTimeEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import io.reactivex.Single

interface HomePageRepository {
    fun getNumOfDaysExercised(): Single<ExerciseTimeEntity>

    fun getUserInfo(): Single<UserInfoEntity>
}
