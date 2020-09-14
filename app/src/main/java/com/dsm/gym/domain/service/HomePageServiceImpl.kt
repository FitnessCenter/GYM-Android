package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ExerciseDayEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.repository.HomePageRepository
import com.dsm.gym.domain.toResult
import io.reactivex.Single

class HomePageServiceImpl(
    private val repository: HomePageRepository,
    private val handler: ErrorHandler
): HomePageService{
    override fun getNumOfDaysExercised(): Single<Result<ExerciseDayEntity>> =
        repository.getNumOfDaysExercised().toResult(handler)

    override fun getUserInfo(): Single<Result<UserInfoEntity>> =
        repository.getUserInfo().toResult(handler)
}