package com.dsm.gym.domain.repository

import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.ChangePasswordEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.RegisterEntity
import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun signIn(auth: AuthEntity): Single<TokenEntity>
    fun signUp(user: RegisterEntity): Completable
    fun saveToken(token: String, isAccess: Boolean)
    fun getToken(isAccess: Boolean): String
    fun changePassword(passwordEntity: ChangePasswordEntity): Completable

}