package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class SignInUseCase(private val authService: AuthService, composite: CompositeDisposable):
    UseCase<Pair<TokenEntity, ErrorHandlerEntity>, AuthEntity>(composite) {

override fun createFlowable(data: AuthEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>
        = authService.signIn(data)
}