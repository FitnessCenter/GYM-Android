package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.ExerciseDayEntity
import com.google.gson.annotations.SerializedName

data class ExerciseDayData(
    @SerializedName("numberOfDaysExercised")
    val numOfExerciseDay: Int
)

fun ExerciseDayData.toEntity() =
    ExerciseDayEntity(
        numOfExerciseDay = numOfExerciseDay
    )