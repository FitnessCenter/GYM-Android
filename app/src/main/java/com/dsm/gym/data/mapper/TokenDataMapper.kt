package com.dsm.gym.data.mapper

import com.dsm.gym.data.entity.TokenData
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.mapper.BaseMapper

class TokenDataMapper: BaseMapper<TokenData,TokenEntity>{
    override fun mapFrom(from: TokenData): TokenEntity
            = TokenEntity(
        token = from.token
    )
}