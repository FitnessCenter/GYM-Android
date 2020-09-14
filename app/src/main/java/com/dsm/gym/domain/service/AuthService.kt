package com.dsm.gym.domain.service

import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.base.Result
import io.reactivex.Single

interface AuthService {
    fun signUp(user: UserEntity): Single<Result<Unit>>

    fun signIn(auth: AuthEntity): Single<Result<Unit>>
}