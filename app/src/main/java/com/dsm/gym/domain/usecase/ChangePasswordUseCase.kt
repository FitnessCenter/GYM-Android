package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.ChangePasswordEntity
import com.dsm.gym.domain.service.AuthService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class ChangePasswordUseCase(private val service : AuthService,composite : CompositeDisposable) : UseCase<ChangePasswordEntity, Result<Unit>>(composite) {
    override fun create(data: ChangePasswordEntity): Single<Result<Unit>> =service.changePassword(data)
}