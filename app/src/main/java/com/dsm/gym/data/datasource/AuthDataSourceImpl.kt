package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.AuthData
import com.dsm.gym.data.entity.RegisterData
import com.dsm.gym.data.entity.TokenData
import com.dsm.gym.data.local.pref.SharedPrefStorage
import com.dsm.gym.data.remote.Api
import io.reactivex.Completable
import io.reactivex.Single

class AuthDataSourceImpl(
    private val api:Api,
    private val pref: SharedPrefStorage): AuthDataSource{
    override fun postSignIn(auth: AuthData): Single<TokenData>
            = api.signIn(auth)

    override fun postSignUp(user: RegisterData): Completable
            = api.signUp(user)

    override fun saveToken(token: String, isAccess: Boolean)
            = pref.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): String
            = pref.getToken(isAccess)
}