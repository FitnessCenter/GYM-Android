package com.dsm.gym.presentation.di.module.domain

import com.dsm.gym.data.handler.AuthErrorHandlerImpl
import com.dsm.gym.domain.handler.AuthErrorHandler
import com.dsm.gym.domain.service.AuthService
import com.dsm.gym.domain.service.AuthServiceImpl
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.domain.usecase.SignUpUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SignUpUseCase(get(), get()) }
    factory { SignInUseCase(get(), get()) }

    factory<AuthErrorHandler> { AuthErrorHandlerImpl() }
    factory<AuthService> { AuthServiceImpl(get(), get()) }
}