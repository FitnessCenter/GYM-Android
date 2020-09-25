package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.ExerciseTimeEntity

data class ExerciseTimeModel(
    val applyTime: Int
)

fun ExerciseTimeModel.toEntity() =
    ExerciseTimeEntity(
        applyTime = applyTime
    )