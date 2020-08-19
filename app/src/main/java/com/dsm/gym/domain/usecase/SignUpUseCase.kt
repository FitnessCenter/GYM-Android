package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class SignUpUseCase(private val authService: AuthService, composite: CompositeDisposable):
    UseCase<Pair<TokenEntity, ErrorHandlerEntity>, UserEntity>(composite) {

    override fun createFlowable(data: UserEntity): Flowable<Pair<TokenEntity, ErrorHandlerEntity>>
            = authService.signUp(data)
}