package com.dsm.gym.presentation.mapper

import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.mapper.BaseMapper
import com.dsm.gym.presentation.model.UserModel

class UserMapper : BaseMapper<UserModel, UserEntity> {
    override fun mapFrom(from: UserModel): UserEntity = UserEntity(
        studentNumber = from.studentNumber,
        studentName = from.studentName,
        id = from.id,
        password = from.password,
        sex = from.sex
    )
}