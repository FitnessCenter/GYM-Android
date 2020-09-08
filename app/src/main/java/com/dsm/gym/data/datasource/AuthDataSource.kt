package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.data.entity.TokenData
import com.dsm.gym.data.entity.UserData
import io.reactivex.Completable
import io.reactivex.Single

interface AuthDataSource{
    fun postSignIn(auth: AuthData): Single<TokenData>

    fun postSignUp(user: UserData): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): String
}