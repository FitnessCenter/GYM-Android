package com.dsm.gym.presentation.di.module.data

import com.dsm.gym.data.repository.AuthRepositoryImpl
import com.dsm.gym.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> { AuthRepositoryImpl(get(), get(), get(), get()) }
}