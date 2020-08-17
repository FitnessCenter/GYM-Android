package com.dsm.gym.data.mapper

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.mapper.BaseMapper

class AuthDataMapper : BaseMapper<AuthEntity, AuthData> {
    override fun mapFrom(from: AuthEntity): AuthData = AuthData(
        id = from.id,
        password = from.password
    )
}