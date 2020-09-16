package com.dsm.gym.domain.entity

import com.dsm.gym.presentation.model.ExerciseDayModel

data class ExerciseDayEntity(
    val numOfExerciseDay:Int
)

fun ExerciseDayEntity.toModel() =
    ExerciseDayModel(
        numOfExerciseDay = numOfExerciseDay
    )