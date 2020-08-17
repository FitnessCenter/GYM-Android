package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.data.entity.TokenData
import com.dsm.gym.data.entity.UserData
import com.dsm.gym.data.local.pref.SharedPrefStorage
import com.dsm.gym.data.remote.Api
import io.reactivex.Flowable

class AuthDataSourceImpl(
    private val api:Api,
    private val pref: SharedPrefStorage): AuthDataSource{
    override fun postSignIn(auth: AuthData): Flowable<TokenData>
            = api.signIn(auth)

    override fun postSignUp(user: UserData): Flowable<TokenData>
            = api.signUp(user)

    override fun saveToken(token: String)
            = pref.saveToken(token)

    override fun getToken(): String
            = pref.getToken()
}