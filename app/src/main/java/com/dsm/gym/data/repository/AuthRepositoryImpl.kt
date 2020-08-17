package com.dsm.gym.data.repository

import android.util.Log
import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.mapper.AuthDataMapper
import com.dsm.gym.data.mapper.TokenDataMapper
import com.dsm.gym.data.mapper.UserDataMapper
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.repository.AuthRepository
import io.reactivex.Flowable

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val authDataMapper: AuthDataMapper,
    private val tokenDataMapper: TokenDataMapper,
    private val userDataMapper: UserDataMapper
) : AuthRepository {
    override fun signIn(auth: AuthEntity): Flowable<TokenEntity> {
        Log.d("authRepo",auth.toString())
        return authDataSource.postSignIn(authDataMapper.mapFrom(auth)).map { tokenDataMapper.mapFrom(it) }
    }


    override fun signUp(user: UserEntity): Flowable<TokenEntity> =
        authDataSource.postSignUp(userDataMapper.mapFrom(user)).map { tokenDataMapper.mapFrom(it) }

    override fun saveToken(token: String) =
        authDataSource.saveToken(token)

    override fun getToken(): String =
        authDataSource.getToken()
}