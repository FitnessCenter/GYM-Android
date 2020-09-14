package com.dsm.gym.domain.extensions

import com.dsm.gym.domain.handler.ErrorHandler
import com.dsm.gym.domain.base.Result
import io.reactivex.Completable
import io.reactivex.Single

fun <T> Single<T>.toResult(errorHandler: ErrorHandler): Single<Result<T>> =
    this.map {
        Result.Success(it) as Result<T>
    }.onErrorReturn {
        Result.Error(errorHandler.errorHandle(it))
    }
fun Completable.toSingleResult(errorHandler: ErrorHandler): Single<Result<Unit>> =
    this.toSingle{}.toResult(errorHandler)