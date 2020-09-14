package com.dsm.gym.domain.entity

import com.dsm.gym.presentation.model.ExerciseTimeModel

data class ExerciseTimeEntity(
    val exerciseTime:Int
)

fun ExerciseTimeEntity.toModel() =
    ExerciseTimeModel(
        exerciseTime = exerciseTime
    )