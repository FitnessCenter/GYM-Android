package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.HomePageDataSource
import com.dsm.gym.data.entity.toEntity
import com.dsm.gym.domain.entity.ExerciseDayEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.repository.HomePageRepository
import io.reactivex.Single

class HomePageRepositoryImpl(
    private val dataSource: HomePageDataSource
):HomePageRepository{
    override fun getNumOfDaysExercised(): Single<ExerciseDayEntity> =
        dataSource.getNumOfDaysExercised().map{it.toEntity()}

    override fun getUserInfo(): Single<UserInfoEntity> =
        dataSource.getUserInfo().map { it.toEntity() }
}