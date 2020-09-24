package com.dsm.gym.domain.usecase

import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.service.HomePageService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetUserInfoUseCase(private val service: HomePageService, composite: CompositeDisposable):
        UseCase<Unit, Result<UserInfoEntity>>(composite){

    override fun create(data: Unit): Single<Result<UserInfoEntity>> =
        service.getUserInfo()
}