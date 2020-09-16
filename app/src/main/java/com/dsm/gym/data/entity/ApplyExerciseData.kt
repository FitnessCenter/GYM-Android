package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.ApplyExerciseEntity

data class ApplyExerciseData(
    val time : Int,
    val numberOfAppliedUser : Int,
    val userLimit : Int,
    val isApplied : Boolean
)

fun ApplyExerciseData.toEntity()=
    ApplyExerciseEntity(
        time,
        numberOfAppliedUser,
        userLimit,
        isApplied
    )