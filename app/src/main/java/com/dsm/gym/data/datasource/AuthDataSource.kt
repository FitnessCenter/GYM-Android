package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.data.entity.RegisterData
import com.dsm.gym.data.entity.TokenData
import io.reactivex.Completable
import io.reactivex.Single

interface AuthDataSource{
    fun postSignIn(auth: AuthData): Single<TokenData>

    fun postSignUp(user: RegisterData): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): String
}