package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.ExerciseTimeEntity
import io.reactivex.Single

interface HomePageRepository {
    fun getNumOfDaysExercised(): Single<ExerciseTimeEntity>
}
