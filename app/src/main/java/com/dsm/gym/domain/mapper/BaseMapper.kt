package com.dsm.gym.domain.mapper

interface BaseMapper<T, E> {
    fun mapFrom(from: T): E
}
