package com.dsm.gym.domain.service

import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import io.reactivex.Flowable

interface AuthService {
    fun signUp(user: UserEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>

    fun signIn(auth: AuthEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>
}