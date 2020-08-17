package com.dsm.gym.data.mapper

import com.dsm.gym.data.entity.UserData
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.mapper.BaseMapper

class UserDataMapper: BaseMapper<UserEntity,UserData>{
    override fun mapFrom(from: UserEntity): UserData
            = UserData(
        studentNumber = from.studentNumber,
        studentName = from.studentName,
        id = from.id,
        password = from.password,
        sex = from.sex
    )
}