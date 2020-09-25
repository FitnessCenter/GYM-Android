package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.RegisterEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SignUpUseCase(private val authService: AuthService, composite: CompositeDisposable):
    UseCase<RegisterEntity, Result<Unit>>(composite) {

    override fun create(data: RegisterEntity): Single<Result<Unit>> =
        authService.signUp(data)

}