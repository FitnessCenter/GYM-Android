package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.ExerciseDayEntity

data class ExerciseDayModel(
    val numOfExerciseDay:Int
)

fun ExerciseDayModel.toEntity() =
    ExerciseDayEntity(
        numOfExerciseDay = numOfExerciseDay
    )