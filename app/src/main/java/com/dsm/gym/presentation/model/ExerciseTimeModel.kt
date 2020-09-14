package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.ExerciseTimeEntity

data class ExerciseTimeModel(
    val exerciseTime:Int
)

fun ExerciseTimeModel.toEntity() =
    ExerciseTimeEntity(
        exerciseTime = exerciseTime
    )