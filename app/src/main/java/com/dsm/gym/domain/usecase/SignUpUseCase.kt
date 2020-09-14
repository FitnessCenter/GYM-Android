package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class SignUpUseCase(private val authService: AuthService, composite: CompositeDisposable):
    UseCase<UserEntity, Result<Unit>>(composite) {

    override fun create(data: UserEntity): Single<Result<Unit>> =
        authService.signUp(data)

}