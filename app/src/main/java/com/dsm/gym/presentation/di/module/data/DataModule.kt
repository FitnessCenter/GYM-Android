package com.dsm.gym.presentation.di.module.data

import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.datasource.AuthDataSourceImpl
import com.dsm.gym.data.local.pref.SharedPrefStorage
import com.dsm.gym.data.local.pref.SharedPrefStorageImpl
import com.dsm.gym.data.mapper.AuthDataMapper
import com.dsm.gym.data.mapper.TokenDataMapper
import com.dsm.gym.data.mapper.UserDataMapper
import com.dsm.gym.presentation.mapper.AuthMapper
import com.dsm.gym.presentation.mapper.UserMapper
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val dataModule = module {
    factory { UserDataMapper() }
    factory { TokenDataMapper() }
    factory { AuthDataMapper() }
    factory { AuthMapper() }
    factory { UserMapper() }

    factory<SharedPrefStorage> { SharedPrefStorageImpl(get()) }

    factory<AuthDataSource> { AuthDataSourceImpl(get(), get()) }

    factory { CompositeDisposable() }
}