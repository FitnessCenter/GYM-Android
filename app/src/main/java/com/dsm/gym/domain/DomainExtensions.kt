package com.dsm.gym.domain

import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.base.Result
import io.reactivex.Completable
import io.reactivex.Single

fun <T> Single<T>.toResult(
    handler: ErrorHandler
): Single<Result<T>> = this
    .map {
        Result.Success(it) as Result<T>
    }
    .onErrorReturn {
        Result.Error(message = handler.errorHandle(it))
    }

fun Completable.toSingleResult(
    handler: ErrorHandler
): Single<Result<Unit>> = this
    .toSingle { Unit }.toResult(handler)