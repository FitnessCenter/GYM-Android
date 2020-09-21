package com.dsm.gym.domain.service

import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.RegisterEntity
import com.dsm.gym.domain.base.Result
import io.reactivex.Single

interface AuthService {
    fun signUp(user: RegisterEntity): Single<Result<Unit>>

    fun signIn(auth: AuthEntity): Single<Result<Unit>>
}