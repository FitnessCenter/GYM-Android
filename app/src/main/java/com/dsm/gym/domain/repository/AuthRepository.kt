package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import io.reactivex.Flowable

interface AuthRepository {
    fun signIn(auth: AuthEntity): Flowable<TokenEntity>
    fun signUp(user: UserEntity): Flowable<TokenEntity>
    fun saveToken(token: String)
    fun getToken(): String
}