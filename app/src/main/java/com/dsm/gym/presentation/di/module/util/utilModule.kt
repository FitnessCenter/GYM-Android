package com.dsm.gym.presentation.di.module.util

import com.dsm.gym.data.base.ErrorHandlerImpl
import com.dsm.gym.data.local.pref.SharedPrefStorage
import com.dsm.gym.data.local.pref.SharedPrefStorageImpl
import com.dsm.gym.domain.base.ErrorHandler
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val utilModule = module {

    factory<SharedPrefStorage> { SharedPrefStorageImpl(get()) }

    factory<ErrorHandler> { ErrorHandlerImpl() }

    factory { CompositeDisposable() }
}