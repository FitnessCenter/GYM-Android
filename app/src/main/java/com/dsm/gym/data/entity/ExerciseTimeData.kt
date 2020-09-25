package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.ExerciseTimeEntity
import com.google.gson.annotations.SerializedName

data class ExerciseTimeData(
    @SerializedName("time")
    val applyTime: Int
)

fun ExerciseTimeData.toEntity() =
    ExerciseTimeEntity(
        applyTime = applyTime
    )