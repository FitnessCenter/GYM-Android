package com.dsm.gym.presentation.mapper

import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.mapper.BaseMapper
import com.dsm.gym.presentation.model.AuthModel

class AuthMapper: BaseMapper<AuthModel,AuthEntity>{
    override fun mapFrom(from: AuthModel): AuthEntity
        = AuthEntity(
        id = from.id,
        password = from.password
    )
}