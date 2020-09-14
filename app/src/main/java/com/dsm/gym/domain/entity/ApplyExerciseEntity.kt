package com.dsm.gym.domain.entity

data class ApplyExerciseEntity(
    val time : Int,
    val numberOfAppliedUser : Int,
    val userLimit : Int,
    val isApplied : Boolean
)