package com.dsm.gym.domain.service

import android.util.Log
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.handler.AuthErrorHandler
import com.dsm.gym.domain.repository.AuthRepository
import io.reactivex.Flowable

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val authErrorHandler: AuthErrorHandler) : AuthService {
    override fun signIn(auth: AuthEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>
            = authRepository.signIn(auth).map{
        TokenEntity(it.token) to ErrorHandlerEntity(isSuccess = true)
    }.doOnNext{
        Log.d("token",it.first.token)
        authRepository.saveToken(it.first.token)
    }.onErrorReturn{
        TokenEntity(authRepository.getToken()) to authErrorHandler.signInErrorHandle(it)
    }

    override fun signUp(user: UserEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>
            = authRepository.signUp(user).map {
        TokenEntity(it.token) to ErrorHandlerEntity(isSuccess = true)
    }.doOnNext{
        authRepository.saveToken(it.first.token)
    }.onErrorReturn{
        TokenEntity(authRepository.getToken()) to authErrorHandler.signUpErrorHandle(it)
    }
}