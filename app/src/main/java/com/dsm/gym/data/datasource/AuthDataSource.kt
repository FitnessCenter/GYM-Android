package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.data.entity.TokenData
import com.dsm.gym.data.entity.UserData
import io.reactivex.Flowable

interface AuthDataSource{
    fun postSignIn(auth: AuthData): Flowable<TokenData>

    fun postSignUp(user: UserData): Flowable<TokenData>

    fun saveToken(token: String)

    fun getToken(): String
}