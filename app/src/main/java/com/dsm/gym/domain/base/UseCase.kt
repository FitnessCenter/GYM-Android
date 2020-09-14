package com.dsm.gym.domain.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, E>(val composite: CompositeDisposable) {

    abstract fun create(data: E): Single<T>

    fun execute(data: E, singleObserver : DisposableSingleObserver<T>) {
        val observer = create(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(singleObserver)

        composite.add(observer)
    }

    fun clear() = composite.clear()
}