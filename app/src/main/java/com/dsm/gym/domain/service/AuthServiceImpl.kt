package com.dsm.gym.domain.service

import AuthRepository
import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.toResult
import com.dsm.gym.domain.toSingleResult
import io.reactivex.Single

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val handler: ErrorHandler
) : AuthService {
    override fun signUp(user: UserEntity): Single<Result<Unit>> =
        authRepository.signUp(user).toSingleResult(handler)

    override fun signIn(auth: AuthEntity): Single<Result<Unit>> =
        authRepository.signIn(auth).map {
            authRepository.saveToken(it.accessToken, true)
            authRepository.saveToken(it.refreshToken, false)
        }
            .toResult(handler)
}