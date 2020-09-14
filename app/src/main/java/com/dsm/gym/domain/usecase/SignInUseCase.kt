package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Single
import com.dsm.gym.domain.base.Result
import io.reactivex.disposables.CompositeDisposable

class SignInUseCase(private val authService: AuthService, composite: CompositeDisposable):
    UseCase<AuthEntity, Result<Unit>>(composite) {

    override fun create(data: AuthEntity): Single<Result<Unit>> =
        authService.signIn(data)

}