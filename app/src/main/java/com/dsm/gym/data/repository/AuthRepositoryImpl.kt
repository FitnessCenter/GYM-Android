package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.entity.toData
import com.dsm.gym.data.entity.toDataEntity
import com.dsm.gym.data.entity.toEntity
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.ChangePasswordEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.RegisterEntity
import com.dsm.gym.domain.repository.AuthRepository
import io.reactivex.Completable
import io.reactivex.Single

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override fun signIn(auth: AuthEntity): Single<TokenEntity> =
        authDataSource.postSignIn(auth.toDataEntity()).map { it.toEntity() }

    override fun signUp(user: RegisterEntity): Completable =
        authDataSource.postSignUp(user.toDataEntity())

    override fun saveToken(token: String, isAccess: Boolean) =
        authDataSource.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): String =
        authDataSource.getToken(isAccess)

    override fun changePassword(passwordEntity: ChangePasswordEntity): Completable = authDataSource.changePassword(passwordEntity.toData())

}