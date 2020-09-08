package com.dsm.gym.data.repository

import android.util.Log
import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.entity.toDataEntity
import com.dsm.gym.data.entity.toEntity
import com.dsm.gym.data.mapper.AuthDataMapper
import com.dsm.gym.data.mapper.TokenDataMapper
import com.dsm.gym.data.mapper.UserDataMapper
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.repository.AuthRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override fun signIn(auth: AuthEntity): Single<TokenEntity>
        = authDataSource.postSignIn(auth.toDataEntity()).map { it.toEntity() }

    override fun signUp(user: UserEntity): Completable =
        authDataSource.postSignUp(user.toDataEntity())

    override fun saveToken(token: String, isAccess: Boolean) =
        authDataSource.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): String =
        authDataSource.getToken(isAccess)
}